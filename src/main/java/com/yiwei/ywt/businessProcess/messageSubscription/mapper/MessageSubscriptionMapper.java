package com.yiwei.ywt.businessProcess.messageSubscription.mapper;

import com.yiwei.ywt.businessProcess.messageSubscription.model.MessageSubscriptionInfo;
import com.yiwei.ywt.framework.dao.CRUDMapper;
import org.apache.ibatis.annotations.Mapper;
/**
 * 短信订阅 mapper
 * @author czy
 * @version 1.0.0
 * @date 2019/04/16 15:54
 */
@Mapper
public interface MessageSubscriptionMapper extends CRUDMapper<MessageSubscriptionInfo> {
    /**
     * 检查手机号有没有绑定过
     * @param mobilePhone
     * @return
     */
    MessageSubscriptionInfo checkMobilePhone(String mobilePhone);

}
