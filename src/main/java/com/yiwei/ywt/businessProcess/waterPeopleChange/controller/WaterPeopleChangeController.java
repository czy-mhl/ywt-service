package com.yiwei.ywt.businessProcess.waterPeopleChange.controller;

import com.yiwei.ywt.businessProcess.waterPeopleChange.model.WaterPeopleChange;
import com.yiwei.ywt.businessProcess.waterPeopleChange.service.WaterPeopleChangeService;
import com.yiwei.ywt.framework.web.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用水人口变更
 */
@RestController
@RequestMapping("/waterpeoplechange")
@Slf4j
public class WaterPeopleChangeController {

    @Resource
    private WaterPeopleChangeService waterPeopleChangeService;

    /**
     * 用水人口变更
     */
//    @LogAop(menuName = "用水人口变更",operationDesc = "新增",operationType = "1")
    @RequestMapping(value = "/addEntity", method = RequestMethod.POST)
     public AjaxResponse getWaterPeopleChange(WaterPeopleChange waterPeopleChange) {
        try {
            return null == this.waterPeopleChangeService.addEntity(waterPeopleChange)? new AjaxResponse(AjaxResponse.FAILURE_ADD_ENTITY,"error") : AjaxResponse.success("ok");
        } catch (Exception e) {
            log.error("add WaterPeopleChange error",e);
            return AjaxResponse.error(e.getMessage(),waterPeopleChange);
        }
    }
}
