package com.yiwei.ywt.businessProcess.temporaryWater.controller;

import com.yiwei.ywt.businessProcess.temporaryWater.model.TemporaryWater;
import com.yiwei.ywt.businessProcess.temporaryWater.service.TemporaryWaterService;
import com.yiwei.ywt.framework.web.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 临时施工用水
 */
@RestController
@RequestMapping("/temporarywater")
@Slf4j
public class TemporaryWaterController {

    @Resource
    private TemporaryWaterService temporaryWaterService;

    /**
     * 临时施工用水
     */
//    @LogAop(menuName = "临时施工用水",operationDesc = "新增",operationType = "1")
    @RequestMapping(value = "/addEntity", method = RequestMethod.POST)
     public AjaxResponse getTemporarywater(TemporaryWater temporaryWater) {
        try {
            return null == this.temporaryWaterService.addEntity(temporaryWater)? new AjaxResponse(AjaxResponse.FAILURE_ADD_ENTITY,"error") : AjaxResponse.success("ok");
        } catch (Exception e) {
            log.error("add TemporaryWater error",e);
            return AjaxResponse.error(e.getMessage(),temporaryWater);
        }
    }
}
