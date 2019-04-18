/**
 * Copyright (C), 2019/4-2019/5, 武汉易维科技股份有限公司
 * FileName: CheckWaterServiceImpl
 * Author:   向珂
 * Date:     2019/4/18
 * Time:     9:24
 * 描述:
 * <author>          <time>          <version>
 * 向珂              2019/4/18           1.0.0
 */
package com.yiwei.ywt.businessProcess.checkWaterMeter.service.impl;

import com.yiwei.ywt.businessProcess.checkWaterMeter.mapper.CheckWaterMeterMapper;
import com.yiwei.ywt.businessProcess.checkWaterMeter.model.CheckWaterMeter;
import com.yiwei.ywt.businessProcess.checkWaterMeter.service.CheckWaterService;
import com.yiwei.ywt.framework.web.AjaxResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class CheckWaterServiceImpl implements CheckWaterService {

    @Resource
    private CheckWaterMeterMapper checkWaterMeterMapper;

    /**
     * 水表验表申请
     *
     * @param checkWaterMeter
     * @return CheckWaterMeter
     */
    @Transactional(rollbackFor = Exception.class)
    public CheckWaterMeter addEntity(CheckWaterMeter checkWaterMeter) {
        if (null == checkWaterMeterMapper.selectByTransactorMobile(checkWaterMeter.getTransactorMobile())) {
            return 0 < checkWaterMeterMapper.insert(checkWaterMeter) ? checkWaterMeter : null;
        }else {
            throw new RuntimeException(AjaxResponse.ERROR_INFO);
        }
    }
}
