package com.yiwei.ywt.framework.config;

/**
 * 微信配置类
 */
 public final class WeiXinConfig {

    /**
     * 开发者ID  wxd09a54fe38cedf42
     */
    public static final String APP_ID = "wxd09a54fe38cedf42";

    /**
     * 密钥  57948a6783c6f65c2c2c98aa38cd5c0d
     */
    public static final String APP_SECRET = "57948a6783c6f65c2c2c98aa38cd5c0d";

    /**
     * 微信获取code地址
     */
    public static final String CODE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?";

    /**
     * 获取ACCESS_TOKEN和OPENID
     */
    public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?";
}
