/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ChangeServiceImpl
 * Author:   XXXXXXX
 * Date:     2019/4/17 11:43
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.yiwei.ywt.businessProcess.residentChange.service.impl;

import com.yiwei.ywt.businessProcess.residentChange.mapper.ResidentChangeMapper;
import com.yiwei.ywt.businessProcess.residentChange.model.ResidentChange;
import com.yiwei.ywt.businessProcess.residentChange.service.ResidentChangeService;
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
public class ResidentChangeServiceImpl implements ResidentChangeService {

    @Resource
    private ResidentChangeMapper residentChangeMapper;

    /**
     * 居民用水改移装
     *
     * @param change
     * @return ResidentChange
     */
    @Transactional(rollbackFor = Exception.class)
    public ResidentChange addEntity(ResidentChange change) {
        if (null == residentChangeMapper.selectByIdCard(change.getIdCard())) {
            return 0 < residentChangeMapper.insert(change) ? change : null;
        }else {
            throw new RuntimeException(AjaxResponse.ERROR_INFO);
        }
    }
}
