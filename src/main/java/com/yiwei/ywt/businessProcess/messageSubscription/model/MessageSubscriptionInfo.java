package com.yiwei.ywt.businessProcess.messageSubscription.model;

import com.yiwei.ywt.framework.model.BaseEntity;
import lombok.Data;
/**
 * 短信订阅 实体类 </p>
 * 数据库表：T_MESSAGE_SUBSCRIPTION
 *
 * @author czy
 * @version 1.0.0
 * @date 2019/04/15 15:54
 */
@Data
public class MessageSubscriptionInfo extends BaseEntity {

    /**
     * 户号
     */
    private String familyCode;
    /**
     * 手机号
     */
    private String mobilePhone;
}
