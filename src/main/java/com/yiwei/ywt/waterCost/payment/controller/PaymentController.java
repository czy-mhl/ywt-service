package com.yiwei.ywt.waterCost.payment.controller;

import com.yiwei.ywt.framework.web.AjaxResponse;
import com.yiwei.ywt.waterCost.bill.model.WaterBillInfo;
import com.yiwei.ywt.waterCost.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 水费缴纳控制器</p>
 * @author czy
 * @version 1.0.0
 * @date 2019/04/17 21:19
 */
@RestController
@RequestMapping(value = "/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    /**
     * 查询代缴费账单
     * @param waterBill
     * @return
     */
//    @LogAop(menuName = "查询代缴费账单",operationDesc = "查询",operationType = "3")
    @RequestMapping(value = "/todoCost", method = RequestMethod.POST)
    public AjaxResponse selectTodoCostBillList(WaterBillInfo waterBill){
        try {
            List<WaterBillInfo> todoWaterBillList= paymentService.selectTodoList(waterBill);
            return null != todoWaterBillList && todoWaterBillList.size()>0 ? AjaxResponse.success("ok",todoWaterBillList):new AjaxResponse(AjaxResponse.FAILURE_SELECT_ENTITY,"查询数据为空");
        } catch (Exception e) {
            log.error("select waterBill error!", e);
            return AjaxResponse.error("error",waterBill);
        }
    }

}
