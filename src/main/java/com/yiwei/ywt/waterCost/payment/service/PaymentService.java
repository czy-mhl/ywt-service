package com.yiwei.ywt.waterCost.payment.service;

import com.yiwei.ywt.waterCost.bill.model.WaterBillInfo;

import java.util.List;

/**
 * 水费缴纳业务层接口</p>
 * @author czy
 * @version 1.0.0
 * @date 2019/04/17 21:19
 */
public interface PaymentService {
    /**
     * 查询待缴费账单列表
     * @param waterBill
     * @return
     */
    List<WaterBillInfo> selectTodoList(WaterBillInfo waterBill);
    /**
     * 结算成功 修改账单状态
     */
    WaterBillInfo updateTodoList(WaterBillInfo waterBillInfo);
}
