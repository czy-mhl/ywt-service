package com.yiwei.ywt.businessProcess.businessChange.mapper;

import com.yiwei.ywt.businessProcess.businessChange.model.BusinessChange;
import com.yiwei.ywt.framework.dao.CRUDMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BusinessChangeMapper extends CRUDMapper<BusinessChange> {

    BusinessChange selectByIdCard(String idCard);

}