package com.yiwei.ywt.businessProcess.residentChange.mapper;

import com.yiwei.ywt.businessProcess.residentChange.model.Change;
import com.yiwei.ywt.framework.dao.CRUDMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChangeMapper extends CRUDMapper<Change> {
    Change selectByIdCard(String idCard);
}