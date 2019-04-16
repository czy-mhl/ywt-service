package com.yiwei.ywt.businessProcess.FileErrorDeclaration.controller;

import com.yiwei.ywt.businessProcess.FileErrorDeclaration.model.FileErrorInfo;
import com.yiwei.ywt.businessProcess.FileErrorDeclaration.service.FileErrorService;
import com.yiwei.ywt.framework.aop.LogAop;
import com.yiwei.ywt.framework.web.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * 档案错误申报 业务处理接口
 * @author czy
 * @version 1.0.0
 * @date 2019/04/16 15:54
 */
@RestController
@RequestMapping(value = "/fileErrorApply")
@Slf4j
public class FileErrorController {

    @Autowired
    private FileErrorService fileErrorService;

    /**
     * 业务申请
     * @param fileErrorInfo
     * @return
     */
    @LogAop(menuName = "档案错误申报业务",operationDesc = "新增",operationType = "1")
    @RequestMapping(value = "/addEntity" , method = RequestMethod.POST)
    public AjaxResponse addEntity(FileErrorInfo fileErrorInfo){
        try {
            return null==this.fileErrorService.addEntity(fileErrorInfo)?new AjaxResponse(AjaxResponse.FAILURE_ADD_ENTITY,"error"):AjaxResponse.success("ok");
        }catch (Exception e){
            log.error(e.getMessage(),fileErrorInfo);
            return AjaxResponse.error(e.getMessage());
        }
    }
}
