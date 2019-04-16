package com.yiwei.ywt.businessProcess.messageSubscription.service;

import com.yiwei.ywt.businessProcess.messageSubscription.model.MessageSubscriptionInfo;
/**
 * 短信订阅
 * @author czy
 * @version 1.0.0
 * @date 2019/04/16 15:54
 */
public interface MessageSubscriptionService {
    /**
     * 订阅
     * @param messageSubscriptionInfo
     * @return
     */
    MessageSubscriptionInfo addEntity(MessageSubscriptionInfo messageSubscriptionInfo);
}
