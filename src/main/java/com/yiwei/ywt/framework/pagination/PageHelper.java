/*
 * Copyright (c) 2016, Seer Tech co. tld. All rights reserved.
 * SEER TECH PROJECT: cherry. Use is subject to license terms.
 *
 *
 *
 *
 *
 */
package com.yiwei.ywt.framework.pagination;

/**
 * 分页帮助类. <p />
 *
 * @author czy
 * @version 1.0.0
 * @date 2017/11/16 下午4:23
 * @since JDK1.8
 */
public class PageHelper {

    /**
     * 创建数据分页的数据分区.
     *
     * @param pageIndex     页码
     * @param pageSize      页大小
     * @return  数据分区信息
     */
    public static DataPartition createDataPartition(Integer pageIndex, Integer pageSize) {
        pageIndex = (pageIndex == null || pageIndex < 0) ? Page.DEFAULT_PAGE_INDEX : pageIndex;
        pageSize = (pageSize == null || pageSize <= 0) ? Page.DEFAULT_PAGE_SIZE : pageSize;
        int first = (pageIndex - 1) * pageSize;
        int last = pageSize;
        return new DataPartition(first, last);
    }
}
