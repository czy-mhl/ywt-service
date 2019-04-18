/**
 * Copyright (C), 2019/4-2019/5, 武汉易维科技股份有限公司
 * FileName: StopWaterServiceImpl
 * Author:   向珂
 * Date:     2019/4/18
 * Time:     9:56
 * 描述:
 * <author>          <time>          <version>
 * 向珂              2019/4/18           1.0.0
 */
package com.yiwei.ywt.businessProcess.stopWaterMeter.service.impl;

import com.yiwei.ywt.businessProcess.stopWaterMeter.mapper.StopWaterMeterMapper;
import com.yiwei.ywt.businessProcess.stopWaterMeter.model.StopWaterMeter;
import com.yiwei.ywt.businessProcess.stopWaterMeter.service.StopWaterService;
import com.yiwei.ywt.framework.web.AjaxResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class StopWaterServiceImpl implements StopWaterService {

    @Resource
    private StopWaterMeterMapper stopWaterMeterMapper;

    /**
     * 暂停申请
     *
     * @param stopWaterMeter
     * @return StopWaterMeter
     */
    @Transactional(rollbackFor = Exception.class)
    public StopWaterMeter addEntity(StopWaterMeter stopWaterMeter) {
        if (null == stopWaterMeterMapper.selectByOwnerMobile(stopWaterMeter.getOwnerMobile())) {
            return 0 < stopWaterMeterMapper.insert(stopWaterMeter) ? stopWaterMeter : null;
        }else {
            throw new RuntimeException(AjaxResponse.ERROR_INFO);
        }
    }
}
