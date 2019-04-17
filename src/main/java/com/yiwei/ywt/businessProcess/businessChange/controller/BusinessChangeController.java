package com.yiwei.ywt.businessProcess.businessChange.controller;

import com.yiwei.ywt.businessProcess.businessChange.model.BusinessChange;
import com.yiwei.ywt.businessProcess.businessChange.service.BusinessChangeService;
import com.yiwei.ywt.businessProcess.residentChange.model.ResidentChange;
import com.yiwei.ywt.framework.web.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 工商用水改移装
 */
@RestController
@RequestMapping("/businesschange")
@Slf4j
public class BusinessChangeController {

    @Resource
    private BusinessChangeService businessChangeService;

    /**
     * 工商用水改移装
     */
//    @LogAop(menuName = "工商用水改移装",operationDesc = "新增",operationType = "1")
    @RequestMapping(value = "/addEntity", method = RequestMethod.POST)
     public AjaxResponse getBusinessChange(BusinessChange businessChange) {
        try {
            return null == this.businessChangeService.addEntity(businessChange)? new AjaxResponse(AjaxResponse.FAILURE_ADD_ENTITY,"error") : AjaxResponse.success("ok");
        } catch (Exception e) {
            log.error("add BusinessChange error",e);
            return AjaxResponse.error(e.getMessage(),businessChange);
        }
    }
}
