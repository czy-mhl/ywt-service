package com.yiwei.ywt.sys.publicity.service;

import com.yiwei.ywt.sys.publicity.model.PublicityInfo;

import java.util.List;

/**
 * @description:
 * @author: czy
 * @date: 2019-04-22 18:05
 * @version: 1.0.0
 */
public interface PublicityInfoService {

   PublicityInfo addEntity(PublicityInfo publicityInfo);

   boolean delEntity(Long id);

   PublicityInfo updateEntity(PublicityInfo publicityInfo);

   List<PublicityInfo> selectEntityByType(String type);

}
