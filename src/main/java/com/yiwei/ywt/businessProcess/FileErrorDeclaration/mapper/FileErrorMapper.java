package com.yiwei.ywt.businessProcess.FileErrorDeclaration.mapper;

import com.yiwei.ywt.businessProcess.FileErrorDeclaration.model.FileErrorInfo;
import com.yiwei.ywt.framework.dao.CRUDMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileErrorMapper extends CRUDMapper<FileErrorInfo> {
}
