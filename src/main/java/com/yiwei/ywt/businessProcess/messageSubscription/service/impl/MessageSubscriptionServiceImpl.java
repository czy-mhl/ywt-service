package com.yiwei.ywt.businessProcess.messageSubscription.service.impl;

import com.yiwei.ywt.businessProcess.messageSubscription.mapper.MessageSubscriptionMapper;
import com.yiwei.ywt.businessProcess.messageSubscription.model.MessageSubscriptionInfo;
import com.yiwei.ywt.businessProcess.messageSubscription.service.MessageSubscriptionService;
import com.yiwei.ywt.framework.web.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 短信订阅 业务处理
 * @author czy
 * @version 1.0.0
 * @date 2019/04/16 15:54
 */
@Service
public class MessageSubscriptionServiceImpl implements MessageSubscriptionService {

    @Autowired
    private MessageSubscriptionMapper messageSubscriptionMapper;

    /**
     * 订阅
     * @param messageSubscriptionInfo
     * @return
     */
    @Override
    public MessageSubscriptionInfo addEntity(MessageSubscriptionInfo messageSubscriptionInfo) throws RuntimeException{
        if (null == this.messageSubscriptionMapper.checkMobilePhone(messageSubscriptionInfo.getMobilePhone()))
            return 0<this.messageSubscriptionMapper.insert(messageSubscriptionInfo)?messageSubscriptionInfo:null;
        else
            throw new RuntimeException(AjaxResponse.ERROR_INFO_PHONE);

    }
}
