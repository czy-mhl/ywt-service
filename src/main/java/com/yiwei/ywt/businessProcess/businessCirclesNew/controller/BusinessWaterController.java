package com.yiwei.ywt.businessProcess.businessCirclesNew.controller;

import com.yiwei.ywt.businessProcess.businessCirclesNew.model.BusinessWater;
import com.yiwei.ywt.businessProcess.businessCirclesNew.service.BusinessWaterService;
import com.yiwei.ywt.framework.web.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 工商用水新装
 */
@RestController
@RequestMapping("/businesswater")
@Slf4j
public class BusinessWaterController {

    @Resource
    private BusinessWaterService businessWaterService;

    /**
     * 工商用水新装申请
     */
//    @LogAop(menuName = "工商用水新装",operationDesc = "新增",operationType = "1")
    @RequestMapping(value = "/addEntity", method = RequestMethod.POST)
     public AjaxResponse getBusinessWater(BusinessWater businessWater) {
        try {
            return null == this.businessWaterService.addEntity(businessWater)? new AjaxResponse(AjaxResponse.FAILURE_ADD_ENTITY,"error") : AjaxResponse.success("ok");
        } catch (Exception e) {
            log.error("add WaterApply error",e);
            return AjaxResponse.error(e.getMessage(),businessWater);
        }
    }
}
