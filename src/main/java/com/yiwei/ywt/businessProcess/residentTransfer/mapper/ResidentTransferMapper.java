package com.yiwei.ywt.businessProcess.residentTransfer.mapper;

import com.yiwei.ywt.businessProcess.residentTransfer.model.ResidentTransfer;
import com.yiwei.ywt.framework.dao.CRUDMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ResidentTransferMapper extends CRUDMapper<ResidentTransfer> {
    ResidentTransfer selectByIdCard(String idCard);
}