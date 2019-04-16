package com.yiwei.ywt.businessProcess.residentNew.controller;

import com.yiwei.ywt.businessProcess.residentNew.model.WaterApply;
import com.yiwei.ywt.businessProcess.residentNew.service.WaterApplyService;
import com.yiwei.ywt.framework.aop.LogAop;
import com.yiwei.ywt.framework.utils.ModelUtil;
import com.yiwei.ywt.framework.web.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 居民用水新装
 */
@RestController
@RequestMapping("/residentwater")
@Slf4j
public class WaterApplyController {

    @Resource
    private WaterApplyService waterApplyService;

    /**
     * 居民用水新装申请
     */
//    @LogAop(menuName = "居民用水新装",operationDesc = "新增",operationType = "1")
    @RequestMapping(value = "/addEntity", method = RequestMethod.POST)
     public AjaxResponse getWaterApply(WaterApply waterApply) {
        try {
            return null == this.waterApplyService.addEntity(waterApply)? new AjaxResponse(AjaxResponse.FAILURE_ADD_ENTITY,"error") : AjaxResponse.success("ok");
        } catch (Exception e) {
            log.error("add WaterApply error",e);
            return AjaxResponse.error(e.getMessage(),waterApply);
        }
    }
}
