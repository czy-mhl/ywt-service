/**
 * Copyright (C), 2019/4-2019/5, 武汉易维科技股份有限公司
 * FileName: PayModeServiceImpl
 * Author:   向珂
 * Date:     2019/4/22
 * Time:     10:16
 * 描述:
 * <author>          <time>          <version>
 * 向珂              2019/4/22           1.0.0
 */
package com.yiwei.ywt.sys.serviceInformation.service.impl;

import com.yiwei.ywt.sys.serviceInformation.mapper.PayModeMapper;
import com.yiwei.ywt.sys.serviceInformation.model.PayMode;
import com.yiwei.ywt.sys.serviceInformation.service.PayModeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PayModeServiceImpl implements PayModeService {

    @Resource
    private PayModeMapper payModeMapper;
    /**
     * 交费方式新增
     *
     * @param payMode
     * @return PayMode
     */
    @Override
    public PayMode addEntity(PayMode payMode) {
        return 0 < payModeMapper.insert(payMode) ? payMode : null;
    }
    /**
     * 交费方式查询
     *
     * @param title
     * @return List<PayMode>
     */
    @Override
    public List<PayMode> selectByTitle(String title) {
        return payModeMapper.selectByTitle(title);
    }
    /**
     * 交费方式修改
     *
     * @param payMode
     * @return boolean
     */
    @Override
    public boolean editEntity(PayMode payMode) {
        return 0 < this.payModeMapper.update(payMode);
    }
    /**
     * 交费方式删除
     *
     * @param id
     * @return boolean
     */
    @Override
    public boolean deleteEntity(Long id) {
        return 0 < this.payModeMapper.delete(id);
    }
}
