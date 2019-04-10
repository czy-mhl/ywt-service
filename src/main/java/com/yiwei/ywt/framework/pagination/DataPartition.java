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
 * 数据分区信息. <p />
 *
 * @author czy
 * @version 1.0.0
 * @date 2017/11/16 下午5:07
 * @since JDK1.8
 */
public class DataPartition {

    /**
     * 数据偏移量.
     */
    private Integer offset;

    /**
     * 数据显示数量.
     */
    private Integer limit;

    public DataPartition(Integer offset, Integer limit) {
        this.offset = offset;
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
