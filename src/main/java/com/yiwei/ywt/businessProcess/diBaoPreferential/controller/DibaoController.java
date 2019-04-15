package com.yiwei.ywt.businessProcess.diBaoPreferential.controller;

import com.yiwei.ywt.businessProcess.diBaoPreferential.model.DibaoInfo;
import com.yiwei.ywt.businessProcess.diBaoPreferential.service.DibaoService;
import com.yiwei.ywt.framework.web.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * 低保业务办理控制器</p>
 * @author czy
 * @version 1.0.0
 * @date 2019/04/14 21:19
 */
@Slf4j
@RestController
@RequestMapping(value = "/dibao")
public class DibaoController {

    @Autowired
    private DibaoService dibaoService;
    //@LogAop(menuName = "低保业务",operationDesc = "新增",operationType = "1")
    @RequestMapping(value = "/addEntity", method = RequestMethod.POST)
    public AjaxResponse addEntity(DibaoInfo dibaoInfo){
        try {
            return null == this.dibaoService.addEntity(dibaoInfo)? new AjaxResponse(AjaxResponse.FAILURE_ADD_ENTITY,"error") : AjaxResponse.success("ok");
        } catch (Exception e) {
            log.error("add dibaoInfo error",e);
            return AjaxResponse.error(e.getMessage(),dibaoInfo);
        }
    }
}
