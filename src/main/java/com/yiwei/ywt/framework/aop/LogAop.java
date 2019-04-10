package com.yiwei.ywt.framework.aop;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})  
@Retention(RetentionPolicy.RUNTIME)  
@Documented 
public @interface LogAop {
	
	/** 操作类型1=新增，2=修改，3=查询，4=删除，5=审核，6=发布 , 7=撤销 ,8=处理,9=其他,10=启用，11=禁用**/  
	public String operationType() default "";  
	
	/** 操作类型名称描述 */
	public String operationDesc() default "";  
	      
    /** 点击的菜单名称 **/  
    public String menuName() default "";
}
