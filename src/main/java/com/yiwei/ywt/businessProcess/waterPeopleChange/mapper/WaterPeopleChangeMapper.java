package com.yiwei.ywt.businessProcess.waterPeopleChange.mapper;

import com.yiwei.ywt.businessProcess.waterPeopleChange.model.WaterPeopleChange;
import com.yiwei.ywt.framework.dao.CRUDMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WaterPeopleChangeMapper extends CRUDMapper<WaterPeopleChange> {
    WaterPeopleChange selectByFamilyNumber(String familyNumber);
}