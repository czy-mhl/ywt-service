/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BusinessTransferServiceImpl
 * Author:   XXXXXXX
 * Date:     2019/4/17 17:31
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.yiwei.ywt.businessProcess.businessTransfer.service.impl;

import com.yiwei.ywt.businessProcess.businessTransfer.mapper.BusinessTransferMapper;
import com.yiwei.ywt.businessProcess.businessTransfer.model.BusinessTransfer;
import com.yiwei.ywt.businessProcess.businessTransfer.service.BusinessTransferService;
import com.yiwei.ywt.businessProcess.residentTransfer.mapper.ResidentTransferMapper;
import com.yiwei.ywt.businessProcess.residentTransfer.model.ResidentTransfer;
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
public class BusinessTransferServiceImpl implements BusinessTransferService {

    @Resource
    private BusinessTransferMapper businessTransferMapper;

    /**
     * 工商客户过户申请
     *
     * @param businessTransfer
     * @return BusinessTransfer
     */
    @Override
    public BusinessTransfer addEntity(BusinessTransfer businessTransfer) {
        //todo 需要短信验证
        if (null == businessTransferMapper.selectByCompanyCard(businessTransfer.getCompanyCard())) {
            return 0 < businessTransferMapper.insert(businessTransfer) ? businessTransfer : null;
        }else {
            throw new RuntimeException(AjaxResponse.ERROR_INFO);
        }
    }
}
