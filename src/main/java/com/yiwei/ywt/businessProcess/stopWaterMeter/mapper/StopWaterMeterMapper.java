package com.yiwei.ywt.businessProcess.stopWaterMeter.mapper;

import com.yiwei.ywt.businessProcess.stopWaterMeter.model.StopWaterMeter;
import com.yiwei.ywt.framework.dao.CRUDMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StopWaterMeterMapper extends CRUDMapper<StopWaterMeter> {
    StopWaterMeter selectByFamilyNumber(String familyNumber);
}