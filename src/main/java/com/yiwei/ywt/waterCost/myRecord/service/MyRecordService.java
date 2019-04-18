package com.yiwei.ywt.waterCost.myRecord.service;

import com.yiwei.ywt.waterCost.myRecord.model.BillingInformation;
import com.yiwei.ywt.waterCost.myRecord.model.MyRecordInfo;

/**
 * 我的档案
 * @author czy
 * @create 2019/4/18
 * @since 1.0.0
 */
public interface MyRecordService {
    /**
     * 根据户号获取我的档案
     * @param myRecordInfo
     * @return
     */
    MyRecordInfo selectEntityByFamilyCode(MyRecordInfo myRecordInfo);
    /**
     * 根据户号修改开票信息
     * @param billingInformation
     * @return
     */
    BillingInformation updateEntityByFamilyCode(BillingInformation billingInformation);
}
