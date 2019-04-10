/*
 * Copyright (c) 2016, Seer Tech co. tld. All rights reserved.
 * SEER TECH PROJECT: cherry. Use is subject to license terms.
 *
 *
 *
 *
 *
 */
package com.yiwei.ywt.framework.web;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 所有控制器的基础类. <p />
 *
 * @author czy
 * @version 1.0.0
 * @date 2019/04/10 下午6:30
 * @since JDK1.8
 */
public abstract class BaseController {

    public static final String LOGIN_USER_KEY = "sessionLoginUser";

    /**
     *
     * 获得放在http session里面的对象. <br/>
     *
     * @param request	请求对象
     * @param clazz	类型
     * @param keyName	HttpSession中的key值
     * @param <E>	对象的类型
     * @return	Http Session里面的对象
     */
    protected <E> E getSessionObj(HttpServletRequest request, Class<E> clazz, String keyName) {
        return clazz.cast(request.getSession(true).getAttribute(keyName));
    }

    /**
     *
     * 获得放在http request里面的对象. <br/>
     *
     * @param request	请求对象
     * @param clazz	类型
     * @param keyName	HttpSession中的key值
     * @param <E>	对象的类型
     * @return	Http Request里面的对象
     */
    protected <E> E getRequestObj(HttpServletRequest request, Class<E> clazz, String keyName) {
        return clazz.cast(request.getAttribute(keyName));
    }

    /**
     * 配合bootstrapValidator的remote验证方法使用，返回验证是否成功的json数据.
     * @param isValid   验证是否成功
     * @return  如果成功返回True
     */
    public Map<String, Boolean> valid(boolean isValid) {
        Map<String, Boolean> response = new HashMap<>();
        response.put("valid", isValid);
        return response;
    }

    /**
     * 数据绑定
     *
     * @param binder
     * WebDataBinder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // 设置List的最大长度
        binder.setAutoGrowCollectionLimit(2048);
    }

}
