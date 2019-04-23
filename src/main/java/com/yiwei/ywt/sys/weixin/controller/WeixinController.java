package com.yiwei.ywt.sys.weixin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yiwei.ywt.framework.utils.HttpClientUtils;
import com.yiwei.ywt.framework.web.AjaxResponse;
import com.yiwei.ywt.sys.weixin.TokenThread;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 微信工具类
 */
@RestController
@Slf4j
@RequestMapping("/wx")
public class WeixinController {
    @Value("${project.url}")
    private String projectUrl;

    /**
     * 获取微信CODE
     */
    @RequestMapping(value = "/code", method = RequestMethod.GET)
    public void getWeiXinCode(HttpServletResponse response) {
        log.info("收到获取微信信息请求");
        // todo 获取项目应用域名
        String redirectUri = "http://wze2rz.natappfree.cc/yiwei" + "/wx/openid";
        String codeUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?" + "appid=" + "wxd09a54fe38cedf42" +
                "&redirect_uri=" + redirectUri + "&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
        try {
            response.sendRedirect(codeUrl);
        } catch (IOException e) {
            log.error("获取微信CODE时出现错误", e);
        }
    }

    /**
     * 获取微信OPENID
     */
    @RequestMapping(value = "/openid", method = RequestMethod.GET)
    public Object getOpenId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取微信CODE
        String code = request.getParameter("code");

        log.info("开始获取微信用户OPENID [{}]", code);
        if (StringUtils.isEmpty(code)) {
            return AjaxResponse.error("未找到微信code");
        }
        String tokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?" + "appid=" + "wxd09a54fe38cedf42" +
                "&secret=" + "57948a6783c6f65c2c2c98aa38cd5c0d" + "&code=" + code + "&grant_type=authorization_code";
        String responseText = HttpClientUtils.httpPostRequest(tokenUrl);
        if (StringUtils.isEmpty(responseText)) {
            return AjaxResponse.error("微信返回信息为空");
        }
        log.info("获取OPENID调用结果:[{}]", responseText);
        JSONObject jsonObject = JSON.parseObject(responseText);
        Object errCode = jsonObject.get("errcode");
        if (null != errCode) {
            String errMsg = jsonObject.getString("errmsg");
            return AjaxResponse.error(errMsg);
        }
        String openId = jsonObject.getString("openid");

        //todo 将openid保存起来，跳转回首页
        ModelMap model = new ModelMap();
        model.addAttribute("openId", openId);
        ModelAndView mv = new ModelAndView("redirect:/index");
        mv.addAllObjects(model);
        return mv;
    }

    @RequestMapping(value = "/token")
    public AjaxResponse token() {
        return null!=TokenThread.token?AjaxResponse.success("OK",TokenThread.token):AjaxResponse.error("error");
    }
}

