package com.yiwei.ywt.businessProcess.checkWaterMeter.mapper;


import com.yiwei.ywt.businessProcess.checkWaterMeter.model.CheckWaterMeter;
import com.yiwei.ywt.framework.dao.CRUDMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CheckWaterMeterMapper extends CRUDMapper<CheckWaterMeter> {
    CheckWaterMeter selectByTransactorMobile(String transactorMobile);
}