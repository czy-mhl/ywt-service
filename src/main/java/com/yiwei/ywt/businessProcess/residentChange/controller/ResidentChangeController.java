package com.yiwei.ywt.businessProcess.residentChange.controller;

import com.yiwei.ywt.businessProcess.residentChange.model.ResidentChange;
import com.yiwei.ywt.businessProcess.residentChange.service.ResidentChangeService;
import com.yiwei.ywt.framework.web.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 居民用水改移装
 */
@RestController
@RequestMapping("/residentchange")
@Slf4j
public class ResidentChangeController {

    @Resource
    private ResidentChangeService residentChangeService;

    /**
     * 居民用水改移装
     */
//    @LogAop(menuName = "居民用水改移装",operationDesc = "新增",operationType = "1")
    @RequestMapping(value = "/addEntity", method = RequestMethod.POST)
     public AjaxResponse getResidentChange(ResidentChange change) {
        try {
            return null == this.residentChangeService.addEntity(change)? new AjaxResponse(AjaxResponse.FAILURE_ADD_ENTITY,"error") : AjaxResponse.success("ok");
        } catch (Exception e) {
            log.error("add ResidentChange error",e);
            return AjaxResponse.error(e.getMessage(),change);
        }
    }
}
