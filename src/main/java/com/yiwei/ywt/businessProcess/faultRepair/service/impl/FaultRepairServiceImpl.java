/**
 * Copyright (C), 2019/4-2019/5, 武汉易维科技股份有限公司
 * FileName: FaultRepairServiceImpl
 * Author:   向珂
 * Date:     2019/4/18
 * Time:     15:59
 * 描述:
 * <author>          <time>          <version>
 * 向珂              2019/4/18           1.0.0
 */
package com.yiwei.ywt.businessProcess.faultRepair.service.impl;

import com.yiwei.ywt.businessProcess.faultRepair.mapper.FaultRepairMapper;
import com.yiwei.ywt.businessProcess.faultRepair.model.FaultRepair;
import com.yiwei.ywt.businessProcess.faultRepair.service.FaultRepairService;
import com.yiwei.ywt.businessProcess.waterNatureChange.mapper.WaterNatureChangeMapper;
import com.yiwei.ywt.businessProcess.waterNatureChange.model.WaterNatureChange;
import com.yiwei.ywt.framework.web.AjaxResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class FaultRepairServiceImpl implements FaultRepairService {

    @Resource
    private FaultRepairMapper faultRepairMapper;

    /**
     * 故障报修
     *
     * @param faultRepair
     * @return FaultRepair
     */
    @Transactional(rollbackFor = Exception.class)
    public FaultRepair addEntity(FaultRepair faultRepair) {
//        if (null == faultRepairMapper.selectByFamilyNumber(faultRepair.getFamilyNumber())) {
            return 0 < faultRepairMapper.insert(faultRepair) ? faultRepair : null;
//        }else {
//            throw new RuntimeException(AjaxResponse.ERROR_INFO);
//        }
    }
}
