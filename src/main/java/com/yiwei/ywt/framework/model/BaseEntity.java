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

import lombok.Data;

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
@Data
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

    /**
     * 删除标记(1=已删除，0=未删除)
     */
    private Integer delFlag;
    /**
     * 描述
     */
    private String description;
    /**
     * 是否启用(1=启用，0=禁用)
     */
    private Integer enabled;

}
