package com.yiwei.ywt.businessProcess.waterNatureChange.mapper;

import com.yiwei.ywt.businessProcess.waterNatureChange.model.WaterNatureChange;
import com.yiwei.ywt.framework.dao.CRUDMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WaterNatureChangeMapper extends CRUDMapper<WaterNatureChange> {
    WaterNatureChange selectByFamilyNumber(String familyNumber);
}