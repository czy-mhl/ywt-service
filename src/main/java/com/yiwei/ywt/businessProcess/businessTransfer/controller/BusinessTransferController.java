package com.yiwei.ywt.businessProcess.businessTransfer.controller;

import com.yiwei.ywt.businessProcess.businessTransfer.mapper.BusinessTransferMapper;
import com.yiwei.ywt.businessProcess.businessTransfer.model.BusinessTransfer;
import com.yiwei.ywt.businessProcess.businessTransfer.service.BusinessTransferService;
import com.yiwei.ywt.businessProcess.residentTransfer.model.ResidentTransfer;
import com.yiwei.ywt.businessProcess.residentTransfer.service.ResidentTransferService;
import com.yiwei.ywt.framework.web.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 工商客户过户
 */
@RestController
@RequestMapping("/businesstransfer")
@Slf4j
public class BusinessTransferController {

    @Resource
    private BusinessTransferService businessTransferService;

    /**
     * 工商客户过户申请
     */
//    @LogAop(menuName = "工商客户过户",operationDesc = "新增",operationType = "1")
    @RequestMapping(value = "/addEntity", method = RequestMethod.POST)
     public AjaxResponse getBusinessTransfer(BusinessTransfer businessTransfer) {
        try {
            return null == this.businessTransferService.addEntity(businessTransfer)? new AjaxResponse(AjaxResponse.FAILURE_ADD_ENTITY,"error") : AjaxResponse.success("ok");
        } catch (Exception e) {
            log.error("add BusinessTransfer error",e);
            return AjaxResponse.error(e.getMessage(),businessTransfer);
        }
    }
}
