package com.yiwei.ywt.businessProcess.faultRepair.mapper;

import com.yiwei.ywt.businessProcess.faultRepair.model.FaultRepair;
import com.yiwei.ywt.framework.dao.CRUDMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FaultRepairMapper extends CRUDMapper<FaultRepair> {
//    FaultRepair selectByFamilyNumber(String familyNumber);
}