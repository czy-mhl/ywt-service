package com.yiwei.ywt.businessProcess.residentChange.mapper;

import com.yiwei.ywt.businessProcess.residentChange.model.ResidentChange;
import com.yiwei.ywt.framework.dao.CRUDMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ResidentChangeMapper extends CRUDMapper<ResidentChange> {
    ResidentChange selectByIdCard(String idCard);
}