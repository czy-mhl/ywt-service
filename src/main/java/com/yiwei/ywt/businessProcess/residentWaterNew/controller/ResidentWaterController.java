package com.yiwei.ywt.businessProcess.residentWaterNew.controller;

import com.yiwei.ywt.businessProcess.residentWaterNew.model.ResidentWater;
import com.yiwei.ywt.businessProcess.residentWaterNew.service.ResidentWaterService;
import com.yiwei.ywt.framework.web.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 居民用水新装
 */
@RestController
@RequestMapping("/residentwater")
@Slf4j
public class ResidentWaterController {

    @Resource
    private ResidentWaterService waterApplyService;

    /**
     * 居民用水新装申请
     */
//    @LogAop(menuName = "居民用水新装",operationDesc = "新增",operationType = "1")
    @RequestMapping(value = "/addEntity", method = RequestMethod.POST)
     public AjaxResponse getResidentWater(ResidentWater residentWater) {
        try {
            return null == this.waterApplyService.addEntity(residentWater)? new AjaxResponse(AjaxResponse.FAILURE_ADD_ENTITY,"error") : AjaxResponse.success("ok");
        } catch (Exception e) {
            log.error("add ResidentWater error",e);
            return AjaxResponse.error(e.getMessage(),residentWater);
        }
    }
}
