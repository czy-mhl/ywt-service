package com.yiwei.ywt.sys.repair.controller;

import com.yiwei.ywt.framework.web.AjaxResponse;
import com.yiwei.ywt.sys.repair.model.Repair;
import com.yiwei.ywt.sys.repair.service.RepairService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 报漏报修
 */
@RestController
@RequestMapping("/repair")
@Slf4j
public class RepairController {

    @Resource
    private RepairService repairService;
    /**
     * （户主）报漏报修申请
     */
//    @LogAop(menuName = "（户主）报漏报修申请申请",operationDesc = "新增",operationType = "1")
    @RequestMapping(value = "/addHouseholderEntity", method = RequestMethod.POST)
     public AjaxResponse addHouseholder(Repair repair) {
        //todo 户主需要验证码通过才能申请
        try {
            //声明此申请人为户主 1 => 户主
            repair.setRepairType(1);
            return null == this.repairService.addEntity(repair)? new AjaxResponse(AjaxResponse.FAILURE_ADD_ENTITY,"error") : AjaxResponse.success("ok");
        } catch (Exception e) {
            log.error("add addHouseholderRepair error",e);
            return AjaxResponse.error(e.getMessage());
        }
    }
    /**
     * （非户主）报漏报修申请
     */
//    @LogAop(menuName = "（非户主）报漏报修申请",operationDesc = "新增",operationType = "1")
    @RequestMapping(value = "/addCustomerEntity", method = RequestMethod.POST)
     public AjaxResponse addCustomer(Repair repair) {
        try {
            //声明此申请人非户主 0 => 非户主
            repair.setRepairType(0);
            return null == this.repairService.addEntity(repair)? new AjaxResponse(AjaxResponse.FAILURE_ADD_ENTITY,"error") : AjaxResponse.success("ok");
        } catch (Exception e) {
            log.error("add addCustomerRepair error",e);
            return AjaxResponse.error(e.getMessage());
        }
    }
}
