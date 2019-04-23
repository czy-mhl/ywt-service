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

import com.yiwei.ywt.businessProcess.againWaterMeter.model.AgainWaterMeter;
import com.yiwei.ywt.businessProcess.checkWaterMeter.mapper.CheckWaterMeterMapper;
import com.yiwei.ywt.businessProcess.checkWaterMeter.model.CheckWaterMeter;
import com.yiwei.ywt.businessProcess.checkWaterMeter.service.CheckWaterService;
import com.yiwei.ywt.businessProcess.handleState.mapper.HandleStateMapper;
import com.yiwei.ywt.businessProcess.handleState.model.HandleState;
import com.yiwei.ywt.framework.web.AjaxResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class CheckWaterServiceImpl implements CheckWaterService {

    @Resource
    private CheckWaterMeterMapper checkWaterMeterMapper;

    @Resource
    private HandleStateMapper handleStateMapper;

    /**
     * 水表验表申请
     *
     * @param checkWaterMeter
     * @return CheckWaterMeter
     */
    @Override
    public CheckWaterMeter addEntity(CheckWaterMeter checkWaterMeter) {
        //todo 必须要绑定户号
        if (null == checkWaterMeterMapper.selectByFamilyNumber(checkWaterMeter.getFamilyNumber())) {
            //水表验表申请 想要插入办理进度业务表 只能存在唯一户号(本业务)
            //按户号校验，不允许重复提交申请
            //todo 添加到办理进度
            HandleState handleState = new HandleState();
            //业务类型（名）
            handleState.setBusinessName(CheckWaterMeter.BUSINESS_NAME);
            //业务办理状态 = 0 = 正在审核
            handleState.setBusinessState(0);
            //申请人姓名
            handleState.setApplyName(checkWaterMeter.getTransactor());
            //申请人联系方式
            handleState.setApplyMobile(checkWaterMeter.getTransactorMobile());
            //复接申请以户号检验
            handleState.setFamilyNumber(checkWaterMeter.getFamilyNumber());
            //添加进办理进度业务表
            if (0 < handleStateMapper.insert(handleState)) {
                //添加成功
            }else {
                //添加失败
                throw new RuntimeException(AjaxResponse.FAILURE_ADD_ENTITY);
            }
            return 0 < checkWaterMeterMapper.insert(checkWaterMeter) ? checkWaterMeter : null;
        }else {
            throw new RuntimeException(AjaxResponse.ERROR_INFO);
        }
    }
}
