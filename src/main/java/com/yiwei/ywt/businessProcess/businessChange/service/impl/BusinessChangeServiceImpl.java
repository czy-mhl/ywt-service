/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BusinessChangeServiceImpl
 * Author:   XXXXXXX
 * Date:     2019/4/17 14:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.yiwei.ywt.businessProcess.businessChange.service.impl;

import com.yiwei.ywt.businessProcess.businessChange.mapper.BusinessChangeMapper;
import com.yiwei.ywt.businessProcess.businessChange.model.BusinessChange;
import com.yiwei.ywt.businessProcess.businessChange.service.BusinessChangeService;
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
public class BusinessChangeServiceImpl implements BusinessChangeService {

    @Resource
    private BusinessChangeMapper businessChangeMapper;

    /**
     * 工商用水改移装
     *
     * @param businessChange
     * @return BusinessChange
     */
    @Transactional(rollbackFor = Exception.class)
    public BusinessChange addEntity(BusinessChange businessChange) {
        if (null == businessChangeMapper.selectByIdCard(businessChange.getIdCard())) {
            return 0 < businessChangeMapper.insert(businessChange) ? businessChange : null;
        }else {
            throw new RuntimeException(AjaxResponse.ERROR_INFO);
        }
    }
}
