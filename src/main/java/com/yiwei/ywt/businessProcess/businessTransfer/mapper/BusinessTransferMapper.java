package com.yiwei.ywt.businessProcess.businessTransfer.mapper;

import com.yiwei.ywt.businessProcess.businessTransfer.model.BusinessTransfer;
import com.yiwei.ywt.framework.dao.CRUDMapper;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface BusinessTransferMapper extends CRUDMapper<BusinessTransfer> {

    BusinessTransfer selectByCompanyCard(String companyCard);

}