/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: WaterApplyServiceImpl
 * Author:   XXXXXXX
 * Date:     2019/4/16 14:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.yiwei.ywt.businessProcess.residentNew.service.impl;

import com.yiwei.ywt.businessProcess.residentNew.mapper.WaterApplyMapper;
import com.yiwei.ywt.businessProcess.residentNew.model.WaterApply;
import com.yiwei.ywt.businessProcess.residentNew.service.WaterApplyService;
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
public class WaterApplyServiceImpl implements WaterApplyService {

    @Resource
    private WaterApplyMapper waterApplyMapper;

    /**
     * 居民用水新装申请
     * @param waterApply
     * @return waterApply
     */
    @Transactional(rollbackFor = Exception.class)
    public WaterApply addEntity(WaterApply waterApply) {
        return 0 < waterApplyMapper.insert(waterApply) ? waterApply : null;
    }
}
