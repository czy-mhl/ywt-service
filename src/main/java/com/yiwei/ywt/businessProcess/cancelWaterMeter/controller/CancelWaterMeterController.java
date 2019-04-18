package com.yiwei.ywt.businessProcess.cancelWaterMeter.controller;

import com.yiwei.ywt.businessProcess.againWaterMeter.model.AgainWaterMeter;
import com.yiwei.ywt.businessProcess.againWaterMeter.service.AgainWaterService;
import com.yiwei.ywt.businessProcess.cancelWaterMeter.model.CancelWaterMeter;
import com.yiwei.ywt.businessProcess.cancelWaterMeter.service.CancelWaterService;
import com.yiwei.ywt.framework.web.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 销户申请
 */
@RestController
@RequestMapping("/cancelwatermeter")
@Slf4j
public class CancelWaterMeterController {

    @Resource
    private CancelWaterService cancelWaterService;

    /**
     * 销户申请
     */
//    @LogAop(menuName = "销户申请",operationDesc = "新增",operationType = "1")
    @RequestMapping(value = "/addEntity", method = RequestMethod.POST)
     public AjaxResponse getCancelWaterMeter(CancelWaterMeter cancelWaterMeter) {
        try {
            return null == this.cancelWaterService.addEntity(cancelWaterMeter)? new AjaxResponse(AjaxResponse.FAILURE_ADD_ENTITY,"error") : AjaxResponse.success("ok");
        } catch (Exception e) {
            log.error("add CancelWaterMeter error",e);
            return AjaxResponse.error(e.getMessage(),cancelWaterMeter);
        }
    }
}
