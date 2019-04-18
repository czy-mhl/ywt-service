package com.yiwei.ywt.businessProcess.againWaterMeter.mapper;

import com.yiwei.ywt.businessProcess.againWaterMeter.model.AgainWaterMeter;
import com.yiwei.ywt.framework.dao.CRUDMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AgainWaterMeterMapper extends CRUDMapper<AgainWaterMeter> {
    AgainWaterMeter selectByOwnerMobile(String ownerMobile);
}