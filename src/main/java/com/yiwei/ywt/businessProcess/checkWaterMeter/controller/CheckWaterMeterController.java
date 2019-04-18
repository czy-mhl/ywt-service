package com.yiwei.ywt.businessProcess.checkWaterMeter.controller;

import com.yiwei.ywt.businessProcess.businessChange.model.BusinessChange;
import com.yiwei.ywt.businessProcess.businessChange.service.BusinessChangeService;
import com.yiwei.ywt.businessProcess.checkWaterMeter.model.CheckWaterMeter;
import com.yiwei.ywt.businessProcess.checkWaterMeter.service.CheckWaterService;
import com.yiwei.ywt.framework.web.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 水表验表申请
 */
@RestController
@RequestMapping("/checkwatermeter")
@Slf4j
public class CheckWaterMeterController {

    @Resource
    private CheckWaterService checkWaterService;

    /**
     * 水表验表申请
     */
//    @LogAop(menuName = "水表验表申请",operationDesc = "新增",operationType = "1")
    @RequestMapping(value = "/addEntity", method = RequestMethod.POST)
     public AjaxResponse getCheckWaterMeter(CheckWaterMeter checkWaterMeter) {
        try {
            return null == this.checkWaterService.addEntity(checkWaterMeter)? new AjaxResponse(AjaxResponse.FAILURE_ADD_ENTITY,"error") : AjaxResponse.success("ok");
        } catch (Exception e) {
            log.error("add CheckWaterMeter error",e);
            return AjaxResponse.error(e.getMessage(),checkWaterMeter);
        }
    }
}
