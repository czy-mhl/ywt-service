package com.yiwei.ywt.sys.weixin.model;

import lombok.Data;
/**
 *
 * 类名称: BaseMessage
 * 类描述: 回复消息的基类
 * @author yuanjun
 * 创建时间:2017年12月8日上午11:38:11
 */
@Data
public class BaseMessage {

    protected String ToUserName;
    protected String FromUserName;
    protected long CreateTime;
    protected String MsgType;
}
