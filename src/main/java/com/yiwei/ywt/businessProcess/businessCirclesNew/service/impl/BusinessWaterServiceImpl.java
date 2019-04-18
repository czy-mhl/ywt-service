/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BusinessServiceImpl
 * Author:   XXXXXXX
 * Date:     2019/4/16 16:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.yiwei.ywt.businessProcess.businessCirclesNew.service.impl;

import com.yiwei.ywt.businessProcess.businessCirclesNew.mapper.BusinessWaterMapper;
import com.yiwei.ywt.businessProcess.businessCirclesNew.model.BusinessWater;
import com.yiwei.ywt.businessProcess.businessCirclesNew.service.BusinessWaterService;
import com.yiwei.ywt.framework.web.AjaxResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author XXXXXXX
 * @create 2019/4/16
 * @since 1.0.0
 */

@Service
public class BusinessWaterServiceImpl implements BusinessWaterService {

    @Resource
    private BusinessWaterMapper businessWaterMapper;

    /**
     * 工商用水新装申请
     * @param businessWater
     * @return BusinessWater
     */
    @Transactional(rollbackFor = Exception.class)
    public BusinessWater addEntity(BusinessWater businessWater) {
        //todo 需要短信验证
        if (null == businessWaterMapper.selectByCreditCode(businessWater.getCreditCode())) {
            return 0 < businessWaterMapper.insert(businessWater) ? businessWater : null;
        } else {
            throw new RuntimeException(AjaxResponse.ERROR_INFO);
        }
    }
}
