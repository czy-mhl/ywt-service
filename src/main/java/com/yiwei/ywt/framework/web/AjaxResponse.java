package com.yiwei.ywt.framework.web;

import java.io.Serializable;

/**
 * Ajax返回对象. <p />
 *
 * Created by czy on 16/9/23.
 */
public class AjaxResponse implements Serializable {
    /**
     * 操作成功.
     */
    public final static String SUCCESS = "00000";

    /**
     * 操作失败.
     */
    public final static String ERROR = "99999";

    /**
     * 添加数据实体失败.
     */
    public static final String FAILURE_ADD_ENTITY = "10001";

    /**
     * 修改数据实体失败.
     */
    public static final String FAILURE_EDIT_ENTITY = "10002";

    /**
     * 删除数据实体失败.
     */
    public static final String FAILURE_DEL_ENTITY = "10003";

    /**
     * 响应结果编码.
     *
     * @see #SUCCESS
     * @see #ERROR
     * @see #FAILURE_ADD_ENTITY
     * @see #FAILURE_EDIT_ENTITY
     * @see #FAILURE_DEL_ENTITY
     */
    private String code;

    /**
     * 响应结果消息.
     */
    private String message;

    /**
     * 响应结果数据.
     */
    private Object data;

    /**
     * 是否session超时 <br/>
     * 针对需要用户登录以后才能访问的请求，用来判断用户登录信息是否已经失效.
     */
    private boolean isSessionTimeout = false;

    /**
     * 是否有权限 <br />
     * 针对需要授权的信息进行访问权限限制，如果是需要授权信息通过则此字段为True，否则为False.
     */
    private boolean isAuthorized = true;

    public AjaxResponse(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static AjaxResponse success(String message) {
        return success(message, null);
    }

    public static AjaxResponse success(String message, Object data) {
        return new AjaxResponse(SUCCESS, message, data);
    }

    public static AjaxResponse error(String message) {
        return error(message, null);
    }

    public static AjaxResponse error(String message, Object data) {
        return new AjaxResponse(ERROR, message, data);
    }

    public boolean getIsSessionTimeout() {
        return isSessionTimeout;
    }

    public void setIsSessionTimeout(boolean isSessionTimeout) {
        this.isSessionTimeout = isSessionTimeout;
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }

    public void setAuthorized(boolean authorized) {
        isAuthorized = authorized;
    }
}
