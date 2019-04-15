package com.yiwei.ywt.businessProcess.messageSubscription.mapper;

import com.yiwei.ywt.businessProcess.messageSubscription.model.MessageSubscriptionInfo;
import com.yiwei.ywt.framework.dao.CRUDMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageSubscriptionMapper extends CRUDMapper<MessageSubscriptionInfo> {
}
