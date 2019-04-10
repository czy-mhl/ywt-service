/*
 * Copyright (c) 2016, Seer Tech co. tld. All rights reserved.
 * SEER TECH PROJECT: cherry. Use is subject to license terms.
 *
 *
 *
 *
 *
 */
package com.yiwei.ywt.framework.service;

import com.yiwei.ywt.framework.dao.RetrieveMapper;
import com.yiwei.ywt.framework.pagination.DataPartition;
import com.yiwei.ywt.framework.pagination.Page;
import com.yiwei.ywt.framework.pagination.PageHelper;

import java.util.List;

/**
 * 所有Service的基础类. <p />
 *
 * @author czy
 * @version 1.0.0
 * @date 2017/11/16 下午4:59
 * @since JDK1.8
 */
public abstract class BaseService<T> {

    /**
     * 创建一个页面信息.
     *
     * @param retrieveMapper    处理数据查询的Mapper
     * @param params            查询的数据参数
     * @param pageIndex         页码
     * @param pageSize          页大小
     * @return  页信息
     */
    protected Page<T> createPage(RetrieveMapper<T> retrieveMapper, T params, Integer pageIndex, Integer pageSize) {
        pageIndex = null == pageIndex ? Page.DEFAULT_PAGE_INDEX : pageIndex;
        pageSize = null == pageSize ? Page.DEFAULT_PAGE_SIZE : pageSize;
        long total = retrieveMapper.count(params);
        DataPartition dataPartition = PageHelper.createDataPartition(pageIndex, pageSize);
        List<T> rows = retrieveMapper.selectPageList(params, dataPartition.getOffset(), dataPartition.getLimit());
        return new Page<>(total, rows, pageIndex, pageSize);
    }

}
