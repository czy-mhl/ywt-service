/**
 * Copyright (C), 2019/4-2019/5, 武汉易维科技股份有限公司
 * FileName: WaterPriceStandarService
 * Author:   向珂
 * Date:     2019/4/21
 * Time:     11:53
 * 描述:
 * <author>          <time>          <version>
 * 向珂               2019/4/21          1.0.0
 */
package com.yiwei.ywt.sys.serviceInformation.service;


import com.yiwei.ywt.sys.serviceInformation.model.WaterPriceStandar;

public interface WaterPriceStandarService {
    WaterPriceStandar addEntity(WaterPriceStandar waterPriceStandar);

    WaterPriceStandar selectByTitle(String title);
}
