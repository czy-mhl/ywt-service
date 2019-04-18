/**
 * Copyright (C), 2019/4-2019/5, 武汉易维科技股份有限公司
 * FileName: CancelWaterServiceImpl
 * Author:   向珂
 * Date:     2019/4/18
 * Time:     13:44
 * 描述:
 * <author>          <time>          <version>
 * 向珂              2019/4/18           1.0.0
 */
package com.yiwei.ywt.businessProcess.cancelWaterMeter.service.impl;

import com.yiwei.ywt.businessProcess.againWaterMeter.mapper.AgainWaterMeterMapper;
import com.yiwei.ywt.businessProcess.cancelWaterMeter.mapper.CancelWaterMeterMapper;
import com.yiwei.ywt.businessProcess.cancelWaterMeter.model.CancelWaterMeter;
import com.yiwei.ywt.businessProcess.cancelWaterMeter.service.CancelWaterService;
import com.yiwei.ywt.framework.web.AjaxResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class CancelWaterServiceImpl implements CancelWaterService {

    @Resource
    private CancelWaterMeterMapper cancelWaterMeterMapper;

    /**
     * 销户申请
     *
     * @param cancelWaterMeter
     * @return CancelWaterMeter
     */
    @Transactional(rollbackFor = Exception.class)
    public CancelWaterMeter addEntity(CancelWaterMeter cancelWaterMeter) {
        if (null == cancelWaterMeterMapper.selectByOwnerMobile(cancelWaterMeter.getOwnerMobile())) {
            return 0 < cancelWaterMeterMapper.insert(cancelWaterMeter) ? cancelWaterMeter : null;
        }else {
            throw new RuntimeException(AjaxResponse.ERROR_INFO);
        }
    }
}
