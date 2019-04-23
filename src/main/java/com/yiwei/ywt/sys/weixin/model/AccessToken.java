package com.yiwei.ywt.sys.weixin.model;

import lombok.Data;

/**
 * @description:
 * @author: czy
 * @date: 2019-04-19 14:34
 * @version: 1.0.0
 */
@Data
public class AccessToken {
    private String access_token;
    private int  expires_in;
}
