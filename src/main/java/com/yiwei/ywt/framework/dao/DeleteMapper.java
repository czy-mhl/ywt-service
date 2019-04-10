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

import org.apache.ibatis.annotations.Param;

/**
 * 处理数据删除的Mapper. <p />
 *
 * @author czy
 * @version 1.0.0
 * @date 2017/11/16 下午4:45
 * @since JDK1.8
 */
public interface DeleteMapper<T> {

    /**
     * 根据ID删除一条记录.
     *
     * @param id    要删除的记录ID
     * @return  删除的结果
     */
    int delete(@Param("id") Long id);
}
