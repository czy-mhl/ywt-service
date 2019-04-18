/**
 * Copyright (C), 2019/4-2019/5, 武汉易维科技股份有限公司
 * FileName: WaterNatureChangeServiceImpl
 * Author:   向珂
 * Date:     2019/4/18
 * Time:     15:06
 * 描述:
 * <author>          <time>          <version>
 * 向珂              2019/4/18           1.0.0
 */
package com.yiwei.ywt.businessProcess.waterNatureChange.service.impl;

import com.yiwei.ywt.businessProcess.waterNatureChange.mapper.WaterNatureChangeMapper;
import com.yiwei.ywt.businessProcess.waterNatureChange.model.WaterNatureChange;
import com.yiwei.ywt.businessProcess.waterNatureChange.service.WaterNatureChangeService;
import com.yiwei.ywt.businessProcess.waterPeopleChange.mapper.WaterPeopleChangeMapper;
import com.yiwei.ywt.businessProcess.waterPeopleChange.model.WaterPeopleChange;
import com.yiwei.ywt.framework.web.AjaxResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class WaterNatureChangeServiceImpl implements WaterNatureChangeService {

    @Resource
    private WaterNatureChangeMapper waterNatureChangeMapper;

    /**
     * 用水人口变更
     *
     * @param waterNatureChange
     * @return WaterNatureChange
     */
    @Transactional(rollbackFor = Exception.class)
    public WaterNatureChange addEntity(WaterNatureChange waterNatureChange) {
        if (null == waterNatureChangeMapper.selectByFamilyNumber(waterNatureChange.getFamilyNumber())) {
            return 0 < waterNatureChangeMapper.insert(waterNatureChange) ? waterNatureChange : null;
        }else {
            throw new RuntimeException(AjaxResponse.ERROR_INFO);
        }
    }
}
