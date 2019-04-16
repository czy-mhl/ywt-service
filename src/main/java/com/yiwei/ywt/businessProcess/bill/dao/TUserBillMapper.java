package com.yiwei.ywt.businessProcess.bill.dao;

import com.yiwei.ywt.framework.dao.CRUDMapper;
import com.yiwei.ywt.businessProcess.bill.model.TUserBill;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TUserBillMapper extends CRUDMapper<TUserBill> {

    /**
     * 根据userId查询出UserBill账单
     */
    TUserBill selectByPrimaryKey(Long PrimaryKey);
    /**
     * 根据userId查询出UserBill账单
     */
    List<TUserBill> selectByUserId(Long userId);

    /**
     * 根据billMonth账单月份查询出UserBill账单
     */
    TUserBill selectBybillMonth(String billMonth);

    /**
     * 根据主键id或userId判断修改或者新增
     */
    int insertUserBill(TUserBill userBill);
}