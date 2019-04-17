package com.yiwei.ywt.businessProcess.residentTransfer.controller;

import com.yiwei.ywt.businessProcess.residentTransfer.model.ResidentTransfer;
import com.yiwei.ywt.businessProcess.residentTransfer.service.ResidentTransferService;
import com.yiwei.ywt.framework.web.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 居民过户
 */
@RestController
@RequestMapping("/residenttransfer")
@Slf4j
public class ResidentTransferController {

    @Resource
    private ResidentTransferService residentTransferService;

    /**
     * 居民用水过户申请
     */
//    @LogAop(menuName = "居民用水过户申请",operationDesc = "新增",operationType = "1")
    @RequestMapping(value = "/addEntity", method = RequestMethod.POST)
     public AjaxResponse getResidentTransfer(ResidentTransfer transfer) {
        try {
            return null == this.residentTransferService.addEntity(transfer)? new AjaxResponse(AjaxResponse.FAILURE_ADD_ENTITY,"error") : AjaxResponse.success("ok");
        } catch (Exception e) {
            log.error("add ResidentTransfer error",e);
            return AjaxResponse.error(e.getMessage(),transfer);
        }
    }
}
