package com.yiwei.ywt;

import com.yiwei.ywt.framework.config.WeiXinConfig;
import com.yiwei.ywt.framework.utils.HttpClientUtils;
import com.yiwei.ywt.sys.weixin.model.AccessToken;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

/**
 * @description:
 * @author: czy
 * @date: 2019-04-18 20:04
 * @version: 1.0.0
 */
@Slf4j
public class test {
    public static String token;
    public static int openId;
    public static  boolean flg = true;
    public static void main(String[] args) {

        while (flg) {
            try {
                AccessToken accessToken = new AccessToken();
                String url = WeiXinConfig.ACCESS_TOKEN_URL;
                url = url.replaceAll("APPID", WeiXinConfig.APP_ID);
                url = url.replaceAll("APPSECRET", WeiXinConfig.APP_SECRET);
                System.err.println(url);
                JSONObject jsonObject = HttpClientUtils.doGetStr(url);
                System.err.println(jsonObject);
                if (null != jsonObject) {
                    accessToken.setAccess_token(jsonObject.getString("access_token"));//取出access_token
                    accessToken.setExpires_in(jsonObject.getInt("expires_in"));//取出access_token的有效期
                    openId = jsonObject.getInt("openid");
                }
                token = accessToken.getAccess_token();
                System.out.println(token+"----"+openId);
                Thread.sleep((accessToken.getExpires_in() - 200) * 1000);
            } catch (Exception e) {
                flg = false;
                log.error("定时获取token异常",e);
            }
        }

    }

}
