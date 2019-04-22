package com.yiwei.ywt.sys.publicity.mapper;


import com.yiwei.ywt.framework.dao.CRUDMapper;
import com.yiwei.ywt.sys.publicity.model.PublicityInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PublicityInfoMapper extends CRUDMapper<PublicityInfo> {

    List<PublicityInfo> getEntityByType(String type);

}