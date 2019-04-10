/*
 * Copyright (c) 2016, Seer Tech co. tld. All rights reserved.
 * SEER TECH PROJECT: cherry. Use is subject to license terms.
 *
 *
 *
 *
 *
 */
package com.yiwei.ywt.framework.dao;

/**
 * 处理数据增加的Mapper. <p />
 *
 * @author czy
 * @version 1.0.0
 * @date 2017/11/16 下午4:39
 * @since JDK1.8
 */
public interface CreateMapper<T> {

    /**
     * 新增一条记录到数据库中.
     *
     * @param param     要新增的数据
     * @return  数据库更新结果
     */
    int insert(T param);
}
