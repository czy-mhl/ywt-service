/*
 * Copyright (c) 2016, Seer Tech co. tld. All rights reserved.
 * SEER TECH PROJECT: cherry. Use is subject to license terms.
 *
 *
 *
 *
 *
 */
package com.yiwei.ywt.framework.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 所有数据库映射实体类的基础类. <p />
 *
 * @author czy
 * @version 1.0.0
 * @date 2017/11/16 下午4:10
 * @see Serializable
 * @since JDK1.8
 */
public abstract class BaseEntity implements Serializable {

    /**
     * ID，表的唯一标识.
     */
    private Long id;

    /**
     * 数据的创建时间.
     */
    private Date createTime;

    /**
     * 数据的最后修改时间.
     */
    private Date lastUpdateTime;

    /**
     * 排序：正序：ASC；倒序：DESC.
     */
    private String sort;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

}
