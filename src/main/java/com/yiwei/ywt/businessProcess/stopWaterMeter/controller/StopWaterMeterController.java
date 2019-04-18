package com.yiwei.ywt.businessProcess.stopWaterMeter.controller;

import com.yiwei.ywt.businessProcess.stopWaterMeter.model.StopWaterMeter;
import com.yiwei.ywt.businessProcess.stopWaterMeter.service.StopWaterService;
import com.yiwei.ywt.framework.web.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 暂停申请
 */
@RestController
@RequestMapping("/stopwatermeter")
@Slf4j
public class StopWaterMeterController {

    @Resource
    private StopWaterService stopWaterService;

    /**
     * 暂停申请
     */
//    @LogAop(menuName = "暂停申请",operationDesc = "新增",operationType = "1")
    @RequestMapping(value = "/addEntity", method = RequestMethod.POST)
     public AjaxResponse getStopWaterMeter(StopWaterMeter stopWaterMeter) {
        try {
            return null == this.stopWaterService.addEntity(stopWaterMeter)? new AjaxResponse(AjaxResponse.FAILURE_ADD_ENTITY,"error") : AjaxResponse.success("ok");
        } catch (Exception e) {
            log.error("add StopWaterMeter error",e);
            return AjaxResponse.error(e.getMessage(),stopWaterMeter);
        }
    }
}
