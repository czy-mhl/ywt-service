package com.yiwei.ywt.waterCost.bill.contorller;

import com.yiwei.ywt.framework.aop.LogAop;
import com.yiwei.ywt.framework.web.AjaxResponse;
import com.yiwei.ywt.waterCost.bill.model.WaterBillInfo;
import com.yiwei.ywt.waterCost.bill.service.WaterBillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 水费账单
 * @author czy
 * @create 2019/4/17
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/bill")
@Slf4j
public class WaterBillController {

    @Resource
    private WaterBillService waterBillService;

    /**
     * 水费账单列表
     * @param waterBill
     * @return AjaxResponse
     */
    @LogAop(menuName = "水费账单列表",operationDesc = "查询",operationType = "3")
    @RequestMapping(value = "/waterBillList", method = RequestMethod.GET)
    public AjaxResponse waterBillList(WaterBillInfo waterBill) {
        try {
            List<WaterBillInfo> waterBillList = this.waterBillService.waterBillList(waterBill);
            return waterBillList.isEmpty()? new AjaxResponse(AjaxResponse.FAILURE_SELECT_ENTITY,"查询数据为空"):AjaxResponse.success("ok",waterBillList);
        }catch(Exception e) {
            log.error("select waterBill error!", e);
            return AjaxResponse.error("error", waterBill);
        }
    }

}
