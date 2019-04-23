package com.yiwei.ywt.framework.config;

/**
 * 微信配置类
 */
 public final class WeiXinConfig {

    /**
     * 开发者ID
     */
    public static final String APP_ID = "wx6c588707277a04d8";

    /**
     * 密钥
     */
    public static final String APP_SECRET = "7f0c6091e7682eea1ec6fbbc25f78cad";

    /**
     * 微信获取code地址
     */
    public static final String CODE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?";
    /**
     * 获取ACCESS_TOKEN和OPENID
     */
    public static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    /**
     * 获取公众号菜单
     */
    public static String GET_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
   /**
    * 新建公众号菜单
    */
    public static String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
   /**
    * 获取用户
    */
    public static String USER_OPENID = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID";
   /**
    * 获取用户信息
    */
    public static String USER_INFORMATION = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
}
