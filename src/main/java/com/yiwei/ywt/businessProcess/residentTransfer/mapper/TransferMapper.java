package com.yiwei.ywt.businessProcess.residentTransfer.mapper;

import com.yiwei.ywt.businessProcess.residentTransfer.model.Transfer;
import com.yiwei.ywt.framework.dao.CRUDMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TransferMapper extends CRUDMapper<Transfer> {
    Transfer selectByIdCard(String idCard);
}