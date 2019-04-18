package com.yiwei.ywt.waterCost.myRecord.controller;

import com.yiwei.ywt.framework.aop.LogAop;
import com.yiwei.ywt.framework.web.AjaxResponse;
import com.yiwei.ywt.waterCost.myRecord.model.BillingInformation;
import com.yiwei.ywt.waterCost.myRecord.model.MyRecordInfo;
import com.yiwei.ywt.waterCost.myRecord.service.MyRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * 我的档案 控制器
 * @author czy
 * @create 2019/4/18
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/record")
@Slf4j
public class MyRecordController {
    @Autowired
    private MyRecordService myRecordService;
    /**
     * 我的档案 和开票信息
     * @param myRecordInfo
     * @return AjaxResponse
     */
    @LogAop(menuName = "查询我的档案",operationDesc = "查询",operationType = "3")
    @RequestMapping(value = "/selectEntityByFamilyCode", method = RequestMethod.POST)
    public AjaxResponse selectEntityByFamilyCode(MyRecordInfo myRecordInfo){
        try {
            MyRecordInfo myRecordInfo1 = this.myRecordService.selectEntityByFamilyCode(myRecordInfo);
            return null == myRecordInfo1? new AjaxResponse(AjaxResponse.FAILURE_SELECT_ENTITY,"查询数据为空"):AjaxResponse.success("ok",myRecordInfo1);
        } catch (Exception e) {
            log.error("select myRecordInfo error",e);
            return AjaxResponse.error("error",myRecordInfo);
        }
    }

    /**
     * 修改开票信息
     * @param billingInformation
     * @return
     */
    @LogAop(menuName = "修改开票信息",operationDesc = "修改",operationType = "2")
    @RequestMapping(value = "/updateEntityByFamilyCode", method = RequestMethod.POST)
    public AjaxResponse updateEntityByFamilyCode(BillingInformation billingInformation){
        try {
            return null == this.myRecordService.updateEntityByFamilyCode(billingInformation)? new AjaxResponse(AjaxResponse.FAILURE_EDIT_ENTITY,"error"):AjaxResponse.success("ok",billingInformation);
        } catch (Exception e) {
            log.error("edit entity error",e);
            return AjaxResponse.error("error",billingInformation);
        }
    }




}
