package com.yiwei.ywt.businessProcess.waterNatureChange.controller;

import com.yiwei.ywt.businessProcess.waterNatureChange.model.WaterNatureChange;
import com.yiwei.ywt.businessProcess.waterNatureChange.service.WaterNatureChangeService;
import com.yiwei.ywt.businessProcess.waterPeopleChange.model.WaterPeopleChange;
import com.yiwei.ywt.businessProcess.waterPeopleChange.service.WaterPeopleChangeService;
import com.yiwei.ywt.framework.web.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用水性质变更
 */
@RestController
@RequestMapping("/waternaturechange")
@Slf4j
public class WaterNatureChangeController {

    @Resource
    private WaterNatureChangeService waterNatureChangeService;

    /**
     * 用水性质变更
     */
//    @LogAop(menuName = "用水性质变更",operationDesc = "新增",operationType = "1")
    @RequestMapping(value = "/addEntity", method = RequestMethod.POST)
     public AjaxResponse getWaterNatureChange(WaterNatureChange waterNatureChange) {
        try {
            return null == this.waterNatureChangeService.addEntity(waterNatureChange)? new AjaxResponse(AjaxResponse.FAILURE_ADD_ENTITY,"error") : AjaxResponse.success("ok");
        } catch (Exception e) {
            log.error("add WaterNatureChange error",e);
            return AjaxResponse.error(e.getMessage(),waterNatureChange);
        }
    }
}
