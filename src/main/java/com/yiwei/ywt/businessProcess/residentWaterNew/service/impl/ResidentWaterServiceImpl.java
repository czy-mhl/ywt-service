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

package com.yiwei.ywt.businessProcess.residentWaterNew.service.impl;

import com.yiwei.ywt.businessProcess.residentWaterNew.mapper.ResidentWaterMapper;
import com.yiwei.ywt.businessProcess.residentWaterNew.model.ResidentWater;
import com.yiwei.ywt.businessProcess.residentWaterNew.service.ResidentWaterService;
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
public class ResidentWaterServiceImpl implements ResidentWaterService {

    @Resource
    private ResidentWaterMapper waterApplyMapper;

    /**
     * 居民用水新装申请
     *
     * @param residentWater
     * @return ResidentWater
     */
    @Transactional(rollbackFor = Exception.class)
    public ResidentWater addEntity(ResidentWater residentWater) {
        //todo 需要短信验证
        if (null == waterApplyMapper.selectByIdCard(residentWater.getIdCard())) {
            return 0 < waterApplyMapper.insert(residentWater) ? residentWater : null;
        }else {
            throw new RuntimeException(AjaxResponse.ERROR_INFO);
        }
    }
}
