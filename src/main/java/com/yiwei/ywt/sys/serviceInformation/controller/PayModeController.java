package com.yiwei.ywt.sys.serviceInformation.controller;

import com.yiwei.ywt.framework.web.AjaxResponse;
import com.yiwei.ywt.sys.serviceInformation.model.PayMode;
import com.yiwei.ywt.sys.serviceInformation.model.WaterPriceStandar;
import com.yiwei.ywt.sys.serviceInformation.service.PayModeService;
import com.yiwei.ywt.sys.serviceInformation.service.WaterPriceStandarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 交费方式
 */
@RestController
@RequestMapping("/paymode")
@Slf4j
public class PayModeController {

    @Resource
    private PayModeService payModeService;

    /**
     * 交费方式新增
     */
//    @LogAop(menuName = "交费方式",operationDesc = "新增",operationType = "1")
    @RequestMapping(value = "/addEntity", method = RequestMethod.POST)
     public AjaxResponse getPayMode(PayMode payMode) {
        try {
            return null == this.payModeService.addEntity(payMode)? new AjaxResponse(AjaxResponse.FAILURE_ADD_ENTITY,"error") : AjaxResponse.success("ok");
        } catch (Exception e) {
            log.error("add PayMode error",e);
            return AjaxResponse.error(e.getMessage());
        }
    }

    /**
     * 交费方式查询（Title）
     */
//    @LogAop(menuName = "交费方式",operationDesc = "查询",operationType = "3")
    @RequestMapping(value = "/selectEntity", method = RequestMethod.GET)
     public AjaxResponse selectPayMode(PayMode payMode) {
        try {
            List<PayMode> payModes = payModeService.selectByTitle(payMode.getTitle());
            return null == payModes ? new AjaxResponse(AjaxResponse.FAILURE_SELECT_ENTITY, "error") : AjaxResponse.success("ok",payModes);
        } catch (RuntimeException e) {
            log.error("select PayMode error",e);
            return AjaxResponse.error("error");
        }
    }

    /**
     * 交费方式修改
     */
//    @LogAop(menuName = "交费方式",operationDesc = "修改",operationType = "2")
    @RequestMapping(value = "/updateEntity", method = RequestMethod.POST)
    public AjaxResponse updatePayMode(PayMode payMode) {
        try {
            return !this.payModeService.editEntity(payMode)? new AjaxResponse(AjaxResponse.FAILURE_EDIT_ENTITY,"error") : AjaxResponse.success("ok");
        } catch (RuntimeException e) {
            log.error("update PayMode error",e);
            return AjaxResponse.error("error");
        }
    }

    /**
     * 交费方式删除
     */
//    @LogAop(menuName = "水价标准",operationDesc = "删除",operationType = "4")
    @RequestMapping(value = "/deleteEntity", method = RequestMethod.POST)
    public AjaxResponse deletePayMode(@RequestParam("ID") Long id) {
        try {
            return !this.payModeService.deleteEntity(id)? new AjaxResponse(AjaxResponse.FAILURE_DEL_ENTITY,"error") : AjaxResponse.success("ok");
        } catch (RuntimeException e) {
            log.error("delete PayMode error",e);
            return AjaxResponse.error("error");
        }
    }
}
