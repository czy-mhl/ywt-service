package com.yiwei.ywt.businessProcess.FileErrorDeclaration.service.impl;

import com.yiwei.ywt.businessProcess.FileErrorDeclaration.mapper.FileErrorMapper;
import com.yiwei.ywt.businessProcess.FileErrorDeclaration.model.FileErrorInfo;
import com.yiwei.ywt.businessProcess.FileErrorDeclaration.service.FileErrorService;
import com.yiwei.ywt.framework.web.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 档案错误申报 业务处理类
 * @author czy
 * @version 1.0.0
 * @date 2019/04/16 15:54
 */
@Service
public class FileErrorServiceImpl implements FileErrorService {

    @Autowired
    private FileErrorMapper fileErrorMapper;

    /**
     * 业务申请
     * @param fileErrorInfo
     * @return
     */
    public FileErrorInfo addEntity(FileErrorInfo fileErrorInfo) throws RuntimeException{
        if(null==this.fileErrorMapper.checkFamilyCode(fileErrorInfo.getFamilyCode()))
            return 0<this.fileErrorMapper.insert(fileErrorInfo)?fileErrorInfo:null;
        else throw new RuntimeException(AjaxResponse.ERROR_INFO);
    }
}
