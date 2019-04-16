package com.yiwei.ywt.sys.bill.service;


import com.yiwei.ywt.sys.bill.model.TUserBill;
import com.yiwei.ywt.sys.user.model.SysUser;

import java.util.List;

public interface SysBillService {

    /**
     * 根据userId查询userBill
     * @param userId
     * @return
     */
    List<TUserBill> findByUserId(Long userId);

    /**
     * 根据billMonth查询userBill
     * @param billMonth
     * @return
     */
    TUserBill findBybillMonth(String billMonth);

    /**
     * 根据TUserBill新增
     * @param userBill
     * @return
     */
    int insertByTUserBill(TUserBill userBill);
}
