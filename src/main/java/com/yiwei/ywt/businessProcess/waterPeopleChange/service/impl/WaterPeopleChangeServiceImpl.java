/**
 * Copyright (C), 2019/4-2019/5, 武汉易维科技股份有限公司
 * FileName: WaterPeopleChangeServiceImpl
 * Author:   向珂
 * Date:     2019/4/18
 * Time:     14:31
 * 描述:
 * <author>          <time>          <version>
 * 向珂              2019/4/18           1.0.0
 */
package com.yiwei.ywt.businessProcess.waterPeopleChange.service.impl;

import com.yiwei.ywt.businessProcess.waterPeopleChange.mapper.WaterPeopleChangeMapper;
import com.yiwei.ywt.businessProcess.waterPeopleChange.model.WaterPeopleChange;
import com.yiwei.ywt.businessProcess.waterPeopleChange.service.WaterPeopleChangeService;
import com.yiwei.ywt.framework.web.AjaxResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class WaterPeopleChangeServiceImpl implements WaterPeopleChangeService {

    @Resource
    private WaterPeopleChangeMapper waterPeopleChangeMapper;

    /**
     * 用水人口变更
     *
     * @param waterPeopleChange
     * @return WaterPeopleChange
     */
    @Transactional(rollbackFor = Exception.class)
    public WaterPeopleChange addEntity(WaterPeopleChange waterPeopleChange) {
        if (null == waterPeopleChangeMapper.selectByFamilyNumber(waterPeopleChange.getFamilyNumber())) {
            return 0 < waterPeopleChangeMapper.insert(waterPeopleChange) ? waterPeopleChange : null;
        }else {
            throw new RuntimeException(AjaxResponse.ERROR_INFO);
        }
    }
}
