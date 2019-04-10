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

import java.util.List;

/**
 * 处理数据查询的Mapper. <p />
 *
 * @author  czy
 * @version 1.0.0
 * @date 2017/04/16 下午4:40
 * @since JDK1.8
 */
public interface RetrieveMapper<T> {

    /**
     * 统计总的记录数.一般情况是单表语句，查询条件为传进来的对象.
     *
     * @param params        查询条件
     * @return  总记录数据
     */
    long count(T params);

    /**
     * 分页查询。一般情况是单表分页，查询条件为传进来的对象.
     *
     * @param params    查询条件
     * @param offset    偏移量
     * @param limit     查询的数据量
     * @return  分页结果集合
     */
    List<T> selectPageList(@Param("searchParams") T params, @Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 个体对象查询。一般情况是单表语句，查询条件为传进来的对象.
     * @param id     查询条件
     * @return  实体对象
     */
    T getEntityById(@Param("id") Long id);



}
