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
     * 水价标准新增
     *
     * @param waterPriceStandar
     * @return WaterPriceStandar
     */
    @Override
    public WaterPriceStandar addEntity(WaterPriceStandar waterPriceStandar) {
        return 0 < waterPriceStandarMapper.insert(waterPriceStandar) ? waterPriceStandar : null;
    }

    /**
     * 水价标准查询
     *
     * @param title
     * @return WaterPriceStandar
     */
    @Override
    public WaterPriceStandar selectByTitle(String title) {
        return waterPriceStandarMapper.selectByTitle(title);
    }

    /**
     * 水价标准修改
     *
     * @param waterPriceStandar
     * @return boolean
     */
    @Override
    public boolean editEntity(WaterPriceStandar waterPriceStandar) {
        return 0 < this.waterPriceStandarMapper.update(waterPriceStandar);
    }

    /**
     * 水价标准删除
     *
     * @param id
     * @return boolean
     */
    @Override
    public boolean deleteEntity(Long id) {
        return 0 < this.waterPriceStandarMapper.delete(id);
    }
}
