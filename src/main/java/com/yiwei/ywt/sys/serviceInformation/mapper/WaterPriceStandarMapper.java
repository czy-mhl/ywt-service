package com.yiwei.ywt.sys.serviceInformation.mapper;

import com.yiwei.ywt.framework.dao.CRUDMapper;
import com.yiwei.ywt.sys.serviceInformation.model.WaterPriceStandar;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WaterPriceStandarMapper extends CRUDMapper<WaterPriceStandar> {
    WaterPriceStandar selectByTitle(String title);
}