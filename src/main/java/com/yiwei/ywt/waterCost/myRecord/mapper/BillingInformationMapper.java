package com.yiwei.ywt.waterCost.myRecord.mapper;

import com.yiwei.ywt.framework.dao.CRUDMapper;
import com.yiwei.ywt.waterCost.myRecord.model.BillingInformation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BillingInformationMapper extends CRUDMapper<BillingInformation> {

    BillingInformation selectEntityByFamilyCode(BillingInformation billingInformation);
}
