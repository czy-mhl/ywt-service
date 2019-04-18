/**
 * Copyright (C), 2019/4-2019/5, 武汉易维科技股份有限公司
 * FileName: AgainWaterServiceImpl
 * Author:   向珂
 * Date:     2019/4/18
 * Time:     9:56
 * 描述:
 * <author>          <time>          <version>
 * 向珂              2019/4/18           1.0.0
 */
package com.yiwei.ywt.businessProcess.againWaterMeter.service.impl;

import com.yiwei.ywt.businessProcess.againWaterMeter.mapper.AgainWaterMeterMapper;
import com.yiwei.ywt.businessProcess.againWaterMeter.model.AgainWaterMeter;
import com.yiwei.ywt.businessProcess.againWaterMeter.service.AgainWaterService;
import com.yiwei.ywt.businessProcess.stopWaterMeter.mapper.StopWaterMeterMapper;
import com.yiwei.ywt.businessProcess.stopWaterMeter.model.StopWaterMeter;
import com.yiwei.ywt.framework.web.AjaxResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class AgainWaterServiceImpl implements AgainWaterService {

    @Resource
    private AgainWaterMeterMapper againWaterMeterMapper;

    /**
     * 复接申请
     *
     * @param againWaterMeter
     * @return AgainWaterMeter
     */
    @Transactional(rollbackFor = Exception.class)
    public AgainWaterMeter addEntity(AgainWaterMeter againWaterMeter) {
        if (null == againWaterMeterMapper.selectByFamilyNumber(againWaterMeter.getFamilyNumber())) {
            return 0 < againWaterMeterMapper.insert(againWaterMeter) ? againWaterMeter : null;
        }else {
            throw new RuntimeException(AjaxResponse.ERROR_INFO);
        }
    }
}
