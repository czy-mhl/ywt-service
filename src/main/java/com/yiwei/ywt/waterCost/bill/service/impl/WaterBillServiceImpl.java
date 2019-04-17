package com.yiwei.ywt.waterCost.bill.service.impl;

import com.yiwei.ywt.framework.utils.DateUtils;
import com.yiwei.ywt.waterCost.bill.mapper.WaterBillMapper;
import com.yiwei.ywt.waterCost.bill.model.WaterBill;
import com.yiwei.ywt.waterCost.bill.service.WaterBillService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 水费账单
 * @author czy
 * @create 2019/4/15
 * @since 1.0.0
 */
@Service
public class WaterBillServiceImpl implements WaterBillService {

    @Resource
    private WaterBillMapper waterBillMapper;

    /**
     * 水费列表
     * @param waterBill == null 默认查
     * @return
     */
    public List<WaterBill> waterBillList(WaterBill waterBill) {
        if(waterBill.getBillMonth() == null){
            SimpleDateFormat sdf = new SimpleDateFormat( "yyyyMM");
            Date nowDate = DateUtils.getNow();
            waterBill.setStartBillMonth(Integer.parseInt(sdf.format(DateUtils.offsetDateByMoney(nowDate,-6))));
            waterBill.setEndBillMonth(Integer.parseInt(sdf.format(DateUtils.offsetDateByMoney(nowDate,1))));
        }
        return this.waterBillMapper.selectListByEntity(waterBill);
    }
}
