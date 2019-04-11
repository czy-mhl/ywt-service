package com.yiwei.ywt.sys.user.controller;

import com.yiwei.ywt.framework.web.AjaxResponse;
import com.yiwei.ywt.framework.web.utils.MD5Util;
import com.yiwei.ywt.sys.user.model.SysUser;
import com.yiwei.ywt.sys.user.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
@Slf4j
public class SysUserController {
    @Resource
    private SysUserService sysUserService;


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse userRegister(@RequestBody Map<String, String> params) {
        try {
            String phone = params.get("phone");
            String pwd = params.get("pwd");
            String confirm = params.get("confirm");
            String code = params.get("code");
            if (!StringUtils.equals(pwd, confirm)) {
                return AjaxResponse.error("密码不一致");
            }
            // todo 调用验证码校验接口
            SysUser user = new SysUser();
            user.setMobile(phone);
            user.setPassword(pwdEncrypt(phone, pwd));
            this.sysUserService.addEntity(user);
            return AjaxResponse.success("");
        } catch(Exception e) {
            return AjaxResponse.error("系统异常");
        }
    }

    private static String pwdEncrypt(String phone, String pwd) throws Exception {
        return MD5Util.GetMD5Code(phone + pwd);
    }

}
