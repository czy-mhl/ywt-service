package com.yiwei.ywt.sys.weixin;

import com.yiwei.ywt.framework.config.WeiXinConfig;
import com.yiwei.ywt.framework.utils.HttpClientUtils;
import com.yiwei.ywt.sys.weixin.model.AccessToken;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时刷新accessToken
 * @author Administrator
 *
 */
@Slf4j
@Component
public class TokenThread {
	public static String token;

    @Scheduled(initialDelay=1000, fixedRate=7000000)
    public void editStatusRefound(){
        try {
            AccessToken accessToken = new AccessToken();
            String url = WeiXinConfig.ACCESS_TOKEN_URL;
            url = url.replaceAll("APPID", WeiXinConfig.APP_ID);
            url = url.replaceAll("APPSECRET", WeiXinConfig.APP_SECRET);
            JSONObject jsonObject = HttpClientUtils.doGetStr(url);
            if (null != jsonObject) {
                accessToken.setAccess_token(jsonObject.getString("access_token"));//取出access_token
                accessToken.setExpires_in(jsonObject.getInt("expires_in"));//取出access_token的有效期
            }
            token = accessToken.getAccess_token();
            System.out.println(token);
        } catch (Exception e) {
            log.error("获取token异常",e);
        }
	}
}

