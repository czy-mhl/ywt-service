package com.yiwei.ywt.businessProcess.cancelWaterMeter.mapper;

import com.yiwei.ywt.businessProcess.cancelWaterMeter.model.CancelWaterMeter;
import com.yiwei.ywt.framework.dao.CRUDMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CancelWaterMeterMapper extends CRUDMapper<CancelWaterMeter> {
    CancelWaterMeter selectByFamilyNumber(String familyNumber);
}