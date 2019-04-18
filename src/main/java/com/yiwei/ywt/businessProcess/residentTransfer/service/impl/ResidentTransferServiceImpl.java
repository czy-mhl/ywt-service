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

import com.yiwei.ywt.businessProcess.residentTransfer.mapper.ResidentTransferMapper;
import com.yiwei.ywt.businessProcess.residentTransfer.model.ResidentTransfer;
import com.yiwei.ywt.businessProcess.residentTransfer.service.ResidentTransferService;
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
public class ResidentTransferServiceImpl implements ResidentTransferService {

    @Resource
    private ResidentTransferMapper residentTransferMapper;

    /**
     * 居民用水过户申请
     *
     * @param transfer
     * @return ResidentTransfer
     */
    @Transactional(rollbackFor = Exception.class)
    public ResidentTransfer addEntity(ResidentTransfer transfer) {
        //todo 需要短信验证
        if (null == residentTransferMapper.selectByIdCard(transfer.getIdCard())) {
            return 0 < residentTransferMapper.insert(transfer) ? transfer : null;
        }else {
            throw new RuntimeException(AjaxResponse.ERROR_INFO);
        }
    }
}
