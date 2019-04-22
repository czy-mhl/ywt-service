/**
 * Copyright (C), 2019/4-2019/5, 武汉易维科技股份有限公司
 * FileName: RepairServiceImpl
 * Author:   向珂
 * Date:     2019/4/22
 * Time:     17:55
 * 描述:
 * <author>          <time>          <version>
 * 向珂              2019/4/22           1.0.0
 */
package com.yiwei.ywt.sys.repair.service.impl;

import com.yiwei.ywt.businessProcess.handleState.mapper.HandleStateMapper;
import com.yiwei.ywt.businessProcess.handleState.model.HandleState;
import com.yiwei.ywt.framework.web.AjaxResponse;
import com.yiwei.ywt.sys.repair.mapper.RepairMapper;
import com.yiwei.ywt.sys.repair.model.Repair;
import com.yiwei.ywt.sys.repair.service.RepairService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RepairServiceImpl implements RepairService {

    @Resource
    private RepairMapper repairMapper;

    @Resource
    private HandleStateMapper handleStateMapper;
    /**
     * 报漏报修申请
     *
     * @param repair
     * @return Repair
     */
    @Override
    public Repair addEntity(Repair repair) {
        //todo 添加到办理进度
        //判断是用户还是非用户操作
        HandleState handleState = new HandleState();
        if (repair.getRepairType() == 1 && repair.getRepairType() != null) {
                //为用户，故障报修考虑到可能办理的中途又多了格外故障，故判定为可重复申请。
                //业务类型（名）
                handleState.setBusinessName(Repair.BUSINESS_NAME);
                //业务办理状态 0 => 正在审核
                handleState.setBusinessState(0);
                //申请人姓名
                handleState.setApplyName(repair.getTransactorName());
                //申请人联系方式
                handleState.setApplyMobile(repair.getTransactorMobile());
                //申请人类别（0 => 非户主，1 => 户主）
                handleState.setApplyType(repair.getRepairType());
                //报漏故障原因描述
                handleState.setApplyReason(repair.getDescription());
                //如果是户主申请，额外存入户主绑定户号
                handleState.setFamilyNumber(repair.getFamilyNumber());
        }else if(repair.getRepairType() == 0 && repair.getRepairType() != null){
            //不为用户，为路人报漏，考虑到极小概率一个路人碰见多个故障，故判定可多次申请。
            //但是次数限制为3次，以手机为检验标准，一个手机号最多申请3次。
            if (handleStateMapper.selectByApplyMobile(repair.getTransactorMobile()).size() < 3) {
                //申请次数小于三次，可以申请。
                //业务类型（名）
                handleState.setBusinessName(Repair.BUSINESS_NAME);
                //业务办理状态 0 => 正在审核
                handleState.setBusinessState(0);
                //申请人姓名
                handleState.setApplyName(repair.getTransactorName());
                //申请人联系方式
                handleState.setApplyMobile(repair.getTransactorMobile());
                //申请人类别（0 => 非户主，1 => 户主）
                handleState.setApplyType(repair.getRepairType());
                //报漏故障原因描述
                handleState.setApplyReason(repair.getDescription());
            }else {
                throw new RuntimeException("非用户路人报漏申请次数超过三次，添加申请失败");
            }
        }else {
            //无法识别
        }
        //添加进办理进度业务表
        if (0 < handleStateMapper.insert(handleState)) {
            //添加成功
        } else {
            //添加失败
            throw new RuntimeException(AjaxResponse.FAILURE_ADD_ENTITY);
        }
        return 0 < repairMapper.insert(repair) ? repair : null;
    }
}
