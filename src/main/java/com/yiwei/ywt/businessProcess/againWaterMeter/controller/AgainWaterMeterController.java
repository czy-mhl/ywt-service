package com.yiwei.ywt.businessProcess.againWaterMeter.controller;

import com.yiwei.ywt.businessProcess.againWaterMeter.model.AgainWaterMeter;
import com.yiwei.ywt.businessProcess.againWaterMeter.service.AgainWaterService;
import com.yiwei.ywt.businessProcess.stopWaterMeter.model.StopWaterMeter;
import com.yiwei.ywt.businessProcess.stopWaterMeter.service.StopWaterService;
import com.yiwei.ywt.framework.web.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 复接申请
 */
@RestController
@RequestMapping("/againwatermeter")
@Slf4j
public class AgainWaterMeterController {

    @Resource
    private AgainWaterService againWaterService;

    /**
     * 复接申请
     */
//    @LogAop(menuName = "复接申请",operationDesc = "新增",operationType = "1")
    @RequestMapping(value = "/addEntity", method = RequestMethod.POST)
     public AjaxResponse getAgainWaterMeter(AgainWaterMeter againWaterMeter) {
        try {
            return null == this.againWaterService.addEntity(againWaterMeter)? new AjaxResponse(AjaxResponse.FAILURE_ADD_ENTITY,"error") : AjaxResponse.success("ok");
        } catch (Exception e) {
            log.error("add AgainWaterMeter error",e);
            return AjaxResponse.error(e.getMessage(),againWaterMeter);
        }
    }
}
