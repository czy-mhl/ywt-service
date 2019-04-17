/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TransferServiceImpl
 * Author:   XXXXXXX
 * Date:     2019/4/17 11:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.yiwei.ywt.businessProcess.residentTransfer.service.impl;

import com.yiwei.ywt.businessProcess.residentNew.mapper.WaterApplyMapper;
import com.yiwei.ywt.businessProcess.residentNew.model.WaterApply;
import com.yiwei.ywt.businessProcess.residentTransfer.mapper.TransferMapper;
import com.yiwei.ywt.businessProcess.residentTransfer.model.Transfer;
import com.yiwei.ywt.businessProcess.residentTransfer.service.TransferService;
import com.yiwei.ywt.framework.web.AjaxResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author XXXXXXX
 * @create 2019/4/17
 * @since 1.0.0
 */
@Service
public class TransferServiceImpl implements TransferService {

    @Resource
    private TransferMapper transferMapper;

    /**
     * 居民用水过户申请
     *
     * @param transfer
     * @return Transfer
     */
    @Transactional(rollbackFor = Exception.class)
    public Transfer addEntity(Transfer transfer) {
        if (null == transferMapper.selectByIdCard(transfer.getIdCard())) {
            return 0 < transferMapper.insert(transfer) ? transfer : null;
        }else {
            throw new RuntimeException(AjaxResponse.ERROR_INFO);
        }
    }
}
