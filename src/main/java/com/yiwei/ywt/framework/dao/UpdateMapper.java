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
 * 处理数据更新的Mapper. <p />
 *
 * @author czy
 * @version 1.0.0
 * @date 2017/4/16 下午4:44
 * @since JDK1.8
 */
public interface UpdateMapper<T> {

    /**
     * 更新一条记录.
     *
     * @param param     要更新的记录
     * @return  更新结果
     */
    int update(T param);
}
