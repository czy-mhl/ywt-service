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

import com.yiwei.ywt.businessProcess.checkWaterMeter.model.CheckWaterMeter;
import com.yiwei.ywt.businessProcess.handleState.mapper.HandleStateMapper;
import com.yiwei.ywt.businessProcess.handleState.model.HandleState;
import com.yiwei.ywt.businessProcess.waterPeopleChange.mapper.WaterPeopleChangeMapper;
import com.yiwei.ywt.businessProcess.waterPeopleChange.model.WaterPeopleChange;
import com.yiwei.ywt.businessProcess.waterPeopleChange.service.WaterPeopleChangeService;
import com.yiwei.ywt.framework.web.AjaxResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class WaterPeopleChangeServiceImpl implements WaterPeopleChangeService {

    @Resource
    private WaterPeopleChangeMapper waterPeopleChangeMapper;

    @Resource
    private HandleStateMapper handleStateMapper;

    /**
     * 用水人口变更
     *
     * @param waterPeopleChange
     * @return WaterPeopleChange
     */
    @Override
    public WaterPeopleChange addEntity(WaterPeopleChange waterPeopleChange) {
        //todo 必须要绑定户号
        if (null == waterPeopleChangeMapper.selectByFamilyNumber(waterPeopleChange.getFamilyNumber())) {
            //用水人口变更申请 想要插入办理进度业务表 只能存在唯一户号(本业务)
            //按户号校验，不允许重复提交申请
            //todo 添加到办理进度
            HandleState handleState = new HandleState();
            //业务类型（名）
            handleState.setBusinessName(WaterPeopleChange.BUSINESS_NAME);
            //业务办理状态 = 0 = 正在审核
            handleState.setBusinessState(0);
            //申请人联系方式
            handleState.setApplyMobile(waterPeopleChange.getTransactorMobile());
            //复接申请以户号检验
            handleState.setFamilyNumber(waterPeopleChange.getFamilyNumber());
            //添加进办理进度业务表
            if (0 < handleStateMapper.insert(handleState)) {
                //添加成功
            }else {
                //添加失败
                throw new RuntimeException(AjaxResponse.FAILURE_ADD_ENTITY);
            }
            return 0 < waterPeopleChangeMapper.insert(waterPeopleChange) ? waterPeopleChange : null;
        }else {
            throw new RuntimeException(AjaxResponse.ERROR_INFO);
        }
    }
}
