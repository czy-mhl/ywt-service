package com.yiwei.ywt.businessProcess.faultRepair.controller;

import com.yiwei.ywt.businessProcess.faultRepair.model.FaultRepair;
import com.yiwei.ywt.businessProcess.faultRepair.service.FaultRepairService;
import com.yiwei.ywt.businessProcess.waterNatureChange.model.WaterNatureChange;
import com.yiwei.ywt.businessProcess.waterNatureChange.service.WaterNatureChangeService;
import com.yiwei.ywt.framework.web.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 故障报修
 */
@RestController
@RequestMapping("/faultrepair")
@Slf4j
public class FaultRepairController {

    @Resource
    private FaultRepairService faultRepairService;

    /**
     * 故障报修
     */
//    @LogAop(menuName = "故障报修",operationDesc = "新增",operationType = "1")
    @RequestMapping(value = "/addEntity", method = RequestMethod.POST)
     public AjaxResponse getFaultRepair(FaultRepair faultRepair) {
        try {
            return null == this.faultRepairService.addEntity(faultRepair)? new AjaxResponse(AjaxResponse.FAILURE_ADD_ENTITY,"error") : AjaxResponse.success("ok");
        } catch (Exception e) {
            log.error("add FaultRepair error",e);
            return AjaxResponse.error(e.getMessage(),faultRepair);
        }
    }
}
