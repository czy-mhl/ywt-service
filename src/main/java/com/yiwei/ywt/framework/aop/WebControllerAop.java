package com.yiwei.ywt.framework.aop;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.yiwei.ywt.framework.utils.CusAccessObjectUtil;
import com.yiwei.ywt.framework.web.WebHelper;
import com.yiwei.ywt.sys.log.service.SysLogService;
import com.yiwei.ywt.sys.user.model.SysUser;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;

import static com.yiwei.ywt.framework.web.BaseController.LOGIN_USER_KEY;

/**
 * 日志记录
 * Created :czy
 * @version 1.0.0
 * @date 2017/8/24 15:10
 */
@Component
@Aspect
public class WebControllerAop {

    private final static Logger LOGGER = LoggerFactory.getLogger(WebControllerAop.class);


    @Autowired
    private SysLogService sysLogService;


    /**
     * 匹配com.mass.api.security.controller包及其子包下的所有类的所有方法
     */
    @Pointcut("execution(* com.yiwei.ywt..*.controller..*.*(..))")
    public void executeService(){

    }

    /**
     * 前置通知，方法调用前被调用
     * @param joinPoint
     */
    @Before("executeService()")
    public void doBeforeAdvice(JoinPoint joinPoint){
        LOGGER.info("我是前置通知!!!");
        //获取目标方法的参数信息
        Object[] obj = joinPoint.getArgs();
        //AOP代理类的信息
        joinPoint.getThis();
        //代理的目标对象
        joinPoint.getTarget();
        //用的最多 通知的签名
        Signature signature = joinPoint.getSignature();
        //代理的是哪一个方法
        LOGGER.info(signature.getName());
        //AOP代理类的名字
        LOGGER.info(signature.getDeclaringTypeName());
        //AOP代理类的类（class）信息
        signature.getDeclaringType();
        //获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        //如果要获取Session信息的话，可以这样写：
        HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
        Enumeration<String> enumeration = request.getParameterNames();
        Map<String,String> parameterMap = Maps.newHashMap();
        while (enumeration.hasMoreElements()){
            String parameter = enumeration.nextElement();
            parameterMap.put(parameter,request.getParameter(parameter));
        }
        String parameterStr = JSON.toJSONString(parameterMap);
        if(obj.length > 0) {
            LOGGER.info("请求的参数信息为："+parameterStr);
        }
//        SysUser sysUser = WebHelper.getSessionAttribute(session, LOGIN_USER_KEY, SysUser.class);
//        if (null != sysUser){
//            this.sysLogService.createSysLog(request.getRequestURL().toString(), CusAccessObjectUtil.getIpAddress(request),sysUser,
//                    3, signature.getDeclaringTypeName(), parameterStr, 1, "");
//        }

    }

    /**
     * 后置返回通知
     * 这里需要注意的是:
     *      如果参数中的第一个参数为JoinPoint，则第二个参数为返回值的信息
     *      如果参数中的第一个参数不为JoinPoint，则第一个参数为returning中对应的参数
     * returning 限定了只有目标方法返回值与通知方法相应参数类型时才能执行后置返回通知，否则不执行，对于returning对应的通知方法参数为Object类型将匹配任何目标返回值
     * @param joinPoint
     * @param keys
     */
    @AfterReturning(value = "executeService()",returning = "keys")
    public void doAfterReturningAdvice1(JoinPoint joinPoint, Object keys){

        //System.out.println("后置返回通知的返回值："+keys);
    }


    /**
     * 后置异常通知
     *  定义一个名字，该名字用于匹配通知实现方法的一个参数名，当目标方法抛出异常返回后，将把目标方法抛出的异常传给通知方法；
     *  throwing 限定了只有目标方法抛出的异常与通知方法相应参数异常类型时才能执行后置异常通知，否则不执行，
     *      对于throwing对应的通知方法参数为Throwable类型将匹配任何异常。
     * @param joinPoint
     * @param exception
     */
    @AfterThrowing(value = "executeService()",throwing = "exception")
    public void doAfterThrowingAdvice(JoinPoint joinPoint, Throwable exception){
        LOGGER.info("发生了异常!!!!!");
        if(exception instanceof NullPointerException){
            LOGGER.info("发生了空指针异常!!!!!");
        }
        //获取目标方法的参数信息
        Object[] obj = joinPoint.getArgs();
        //用的最多 通知的签名
        Signature signature = joinPoint.getSignature();
        //获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        //如果要获取Session信息的话，可以这样写：
        HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
        Enumeration<String> enumeration = request.getParameterNames();
        Map<String,String> parameterMap = Maps.newHashMap();
        while (enumeration.hasMoreElements()){
            String parameter = enumeration.nextElement();
            parameterMap.put(parameter,request.getParameter(parameter));
        }
        String parameterStr = JSON.toJSONString(parameterMap);
        if(obj.length > 0) {
            LOGGER.info("请求的参数信息为："+parameterStr);
        }
        try {
            String targetName = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            Object[] arguments = joinPoint.getArgs();
            Method[] methods = Class.forName(targetName).getMethods();
            String operationType = "";
            String menuName = "";
            String operationDesc = "";
            boolean flag = false;
    	     for (Method method : methods) {
    	    	 if(method.getAnnotation(LogAop.class) != null){//判断方法上面是否有自定义注解
    	             if (method.getName().equals(methodName)) {
    	                Class[] clazzs = method.getParameterTypes();
    	                 if (clazzs.length == arguments.length) {
    	                	 flag = true;
    	                     operationType = method.getAnnotation(LogAop.class).operationType();
    	                     menuName = method.getAnnotation(LogAop.class).menuName();
    	                     operationDesc = method.getAnnotation(LogAop.class).operationDesc();
    	                     break;
    	                }
    	            }
    	    	  }
    	        }
                if(flag) {
                	 //*========控制台输出=========*//
                    System.out.println("=====controller后置通知开始=====");
                    //*========数据库日志=========*//
                    SysUser sysUser = WebHelper.getSessionAttribute(session, LOGIN_USER_KEY, SysUser.class);
                    if (null != sysUser){
                        this.sysLogService.createSysLog(request.getRequestURL().toString(), CusAccessObjectUtil.getIpAddress(request),sysUser,
                                operationType,operationDesc, signature.getDeclaringTypeName(), parameterStr, 2, "",menuName);
                    }
                }
            }  catch (Exception e) {
                //记录本地异常日志
            	LOGGER.error("==后置通知异常==");
            	LOGGER.error("异常信息:{}", e.getMessage());
            }
    }

    /**
     * 后置最终通知（目标方法只要执行完了就会执行后置通知方法）
     * @param joinPoint
     */
    @After("executeService()")
    public void doAfterAdvice(JoinPoint joinPoint){
         LOGGER.info("后置最终通知!!!!!");
        //获取目标方法的参数信息
        Object[] obj = joinPoint.getArgs();
        //用的最多 通知的签名
        Signature signature = joinPoint.getSignature();
        //获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        //如果要获取Session信息的话，可以这样写：
        HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
        Enumeration<String> enumeration = request.getParameterNames();
        Map<String,String> parameterMap = Maps.newHashMap();
        while (enumeration.hasMoreElements()){
            String parameter = enumeration.nextElement();
            parameterMap.put(parameter,request.getParameter(parameter));
        }
        String parameterStr = JSON.toJSONString(parameterMap);
        if(obj.length > 0) {
            LOGGER.info("请求的参数信息为："+parameterStr);
        }
   try {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Method[] methods = Class.forName(targetName).getMethods();
        String operationType = "";
        String menuName = "";
        String operationDesc = "";
        boolean flag = false;
	     for (Method method : methods) {
	    	 if(method.getAnnotation(LogAop.class) != null){//判断方法上面是否有自定义注解
	             if (method.getName().equals(methodName)) {
	                Class[] clazzs = method.getParameterTypes();
	                 if (clazzs.length == arguments.length) {
	                	 flag = true;
	                     operationType = method.getAnnotation(LogAop.class).operationType();
	                     menuName = method.getAnnotation(LogAop.class).menuName();
	                     operationDesc = method.getAnnotation(LogAop.class).operationDesc();
	                     break;
	                }
	            }
	    	  }
	        }
            if(flag) {
            	 //*========控制台输出=========*//
                System.out.println("=====controller后置通知开始=====");
                //*========数据库日志=========*//
                SysUser sysUser = WebHelper.getSessionAttribute(session, LOGIN_USER_KEY, SysUser.class);
                if (null != sysUser){
                    this.sysLogService.createSysLog(request.getRequestURL().toString(), CusAccessObjectUtil.getIpAddress(request),sysUser,
                            operationType,operationDesc, signature.getDeclaringTypeName(), parameterStr, 1, "",menuName);
                }
            }
        }  catch (Exception e) {
            //记录本地异常日志
        	LOGGER.error("==后置通知异常==");
        	LOGGER.error("异常信息:{}", e.getMessage());
        }
    }


}
