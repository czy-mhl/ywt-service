package com.yiwei.ywt.waterCost.bill.service;

import com.yiwei.ywt.waterCost.bill.model.WaterBill;

import java.util.List;

/**
 * 水费账单
 * @author czy
 * @create 2019/4/15
 * @since 1.0.0
 */
public interface WaterBillService {
    /**
     * 水费列表
     * @param waterBill
     * @return
     */
    List<WaterBill> waterBillList(WaterBill waterBill);

}
