/**
 * Copyright (C), 2019/4-2019/5, 武汉易维科技股份有限公司
 * FileName: WaterPriceStandarServiceImpl
 * Author:   向珂
 * Date:     2019/4/21
 * Time:     11:53
 * 描述:
 * <author>          <time>          <version>
 * 向珂              2019/4/21           1.0.0
 */
package com.yiwei.ywt.sys.serviceInformation.service.impl;

import com.yiwei.ywt.sys.serviceInformation.mapper.WaterPriceStandarMapper;
import com.yiwei.ywt.sys.serviceInformation.model.WaterPriceStandar;
import com.yiwei.ywt.sys.serviceInformation.service.WaterPriceStandarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class WaterPriceStandarServiceImpl implements WaterPriceStandarService {

    @Resource
    private WaterPriceStandarMapper waterPriceStandarMapper;

    /**
     * 水价标准
     *
     * @param waterPriceStandar
     * @return WaterPriceStandar
     */
    @Override
    public WaterPriceStandar addEntity(WaterPriceStandar waterPriceStandar) {
        return 0 < waterPriceStandarMapper.insert(waterPriceStandar) ? waterPriceStandar : null;
    }

    @Override
    public WaterPriceStandar selectByTitle(String title) {
        return waterPriceStandarMapper.selectByTitle(title);
    }
}
