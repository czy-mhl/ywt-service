package com.yiwei.ywt.waterCost.bill.contorller;

import com.yiwei.ywt.framework.web.AjaxResponse;
import com.yiwei.ywt.waterCost.bill.model.WaterBill;
import com.yiwei.ywt.waterCost.bill.service.WaterBillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 水费账单
 * @author 向珂
 * @create 2019/4/15
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/user")
@Slf4j
public class WaterBillController {

    @Resource
    private WaterBillService waterBillService;

   /**
     * 水费账单列表
     * @param waterBill
     * @return AjaxResponse
     */
    @RequestMapping(value = "/waterBillList", method = RequestMethod.GET)
    public AjaxResponse waterBillList(WaterBill waterBill) {
        try {
            List<WaterBill> waterBillList = this.waterBillService.waterBillList(waterBill);
            return null == waterBillList ? new AjaxResponse(AjaxResponse.FAILURE_SELECT_ENTITY,"error") : AjaxResponse.success("ok",waterBillList);
        }
        catch(Exception e) {
            log.error("select waterBill error!", e);
            return AjaxResponse.error("error", waterBill);
        }
    }

    /*/**
     * 根据mouthTotal查询UserBill
     * @param billMonth
     * @return AjaxResponse
     *//*
    @RequestMapping(value = "/billdetails/{billMonth}", method = RequestMethod.GET)
    public AjaxResponse userBill(@RequestBody @PathVariable("billMonth") String billMonth) {
        try {
            waterBill userBill = this.sysBillService.findBybillMonth(billMonth);
            return null == userBill ? new AjaxResponse(AjaxResponse.FAILURE_SELECT_ENTITY,
                    "error") : AjaxResponse.success("ok",userBill);
        }
        catch(Exception e) {
            log.error("add SysMenu error!", e);
            return AjaxResponse.error("error", billMonth);
        }
    }

    *//**
     * 根据TUserBill新增或更新记录
     * @param userBill
     * @return AjaxResponse
     *//*
    @RequestMapping(value = "/waterBill/add", method = RequestMethod.POST)
    public AjaxResponse userBill(@RequestBody waterBill userBill) {
        try {
            sysBillService.insertByTUserBill(userBill);
            return null == userBill ? new AjaxResponse(AjaxResponse.FAILURE_SELECT_ENTITY,
                    "error") : AjaxResponse.success("ok",userBill);
        }
        catch(Exception e) {
            log.error("add SysMenu error!", e);
            return AjaxResponse.error("error", userBill);
        }
    }*/
}
