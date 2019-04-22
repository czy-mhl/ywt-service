package com.yiwei.ywt.sys.publicity.service.impl;

import com.yiwei.ywt.sys.publicity.mapper.PublicityInfoMapper;
import com.yiwei.ywt.sys.publicity.model.PublicityInfo;
import com.yiwei.ywt.sys.publicity.service.PublicityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: czy
 * @date: 2019-04-22 18:05
 * @version: 1.0.0
 */
@Service
public class PublicityInfoServiceImpl implements PublicityInfoService {
    @Autowired
    private PublicityInfoMapper publicityInfoMapper;
    @Override
    public PublicityInfo addEntity(PublicityInfo publicityInfo) {
        return 0<this.publicityInfoMapper.insert(publicityInfo)?publicityInfo:null;
    }

    @Override
    public boolean delEntity(Long id) {
        return 0<this.publicityInfoMapper.delete(id)?true:null;
    }

    @Override
    public PublicityInfo updateEntity(PublicityInfo publicityInfo) {
        return 0<this.publicityInfoMapper.update(publicityInfo)?publicityInfo:null;
    }

    @Override
    public List<PublicityInfo> selectEntityByType(String type) {
        return this.publicityInfoMapper.getEntityByType(type);
    }
}
