/**
 * Copyright (C), 2019/4-2019/5, 武汉易维科技股份有限公司
 * FileName: PayModeService
 * Author:   向珂
 * Date:     2019/4/22
 * Time:     10:16
 * 描述:
 * <author>          <time>          <version>
 * 向珂               2019/4/22          1.0.0
 */
package com.yiwei.ywt.sys.serviceInformation.service;

import com.yiwei.ywt.sys.serviceInformation.model.PayMode;

import java.util.List;

public interface PayModeService {
    PayMode addEntity(PayMode payMode);

    List<PayMode> selectByTitle(String title);

    boolean editEntity(PayMode payMode);

    boolean deleteEntity(Long id);
}
