package com.yiwei.ywt.businessProcess.diBaoPreferential.service.impl;

import com.yiwei.ywt.businessProcess.diBaoPreferential.mapper.DibaoMapper;
import com.yiwei.ywt.businessProcess.diBaoPreferential.model.DibaoInfo;
import com.yiwei.ywt.businessProcess.diBaoPreferential.service.DibaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author czy
 * @version 1.0.0
 * @date 2019/04/15 15:54
 */
@Service
public class DibaoServiceImpl implements DibaoService{
    @Autowired
    private DibaoMapper dibaoMapper;

    /**
     * 低保用水申请
     * @param dibaoInfo
     * @return
     * @throws RuntimeException
     */
    @Override
    public DibaoInfo addEntity(DibaoInfo dibaoInfo) throws RuntimeException{
        if(null == dibaoMapper.checkFamilyCode(dibaoInfo.getFamilyCode()))
            return  0 < dibaoMapper.insert(dibaoInfo) ? dibaoInfo : null;
        else
            throw new RuntimeException("业务办理中 请勿重复申请");

    }
}
