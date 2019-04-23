/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TemporaryWaterServiceImpl
 * Author:   XXXXXXX
 * Date:     2019/4/16 18:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.yiwei.ywt.businessProcess.temporaryWater.service.impl;

import com.yiwei.ywt.businessProcess.temporaryWater.mapper.TemporaryWaterMapper;
import com.yiwei.ywt.businessProcess.temporaryWater.model.TemporaryWater;
import com.yiwei.ywt.businessProcess.temporaryWater.service.TemporaryWaterService;
import com.yiwei.ywt.framework.web.AjaxResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class TemporaryWaterServiceImpl implements TemporaryWaterService {

    @Resource
    private TemporaryWaterMapper temporaryWaterMapper;

    /**
     * 临时施工用水
     *
     * @param temporaryWater
     * @return BusinessWater
     */
    @Override
    public TemporaryWater addEntity(TemporaryWater temporaryWater) {
        //todo 需要短信验证
        if (null == temporaryWaterMapper.selectByCreditCode(temporaryWater.getCreditCode())) {
            return 0 < temporaryWaterMapper.insert(temporaryWater) ? temporaryWater : null;
        } else {
            throw new RuntimeException(AjaxResponse.ERROR_INFO);
        }
    }
}
