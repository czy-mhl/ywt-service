package com.yiwei.ywt.businessProcess.FileErrorDeclaration.service;

import com.yiwei.ywt.businessProcess.FileErrorDeclaration.model.FileErrorInfo;
/**
 * 档案错误申报
 * @author czy
 * @version 1.0.0
 * @date 2019/04/16 15:54
 */
public interface FileErrorService {
    /**
     * 业务申请
     * @param fileErrorInfo
     * @return
     */
    FileErrorInfo addEntity(FileErrorInfo fileErrorInfo);
}
