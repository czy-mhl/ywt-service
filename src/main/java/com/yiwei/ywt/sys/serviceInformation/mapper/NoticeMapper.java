package com.yiwei.ywt.sys.serviceInformation.mapper;

import com.yiwei.ywt.framework.dao.CRUDMapper;
import com.yiwei.ywt.sys.serviceInformation.model.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper extends CRUDMapper<Notice> {
    List<Notice> selectAll();
}