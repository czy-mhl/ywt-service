package com.yiwei.ywt.sys.serviceInformation.model;

import com.yiwei.ywt.framework.model.BaseEntity;
import lombok.Data;

/**
 * 公告业务 实体类
 * 数据库表：t_notice
 *
 * @author xk
 * @version 1.0.0
 * @date 2019/04/22
 */
@Data
public class Notice extends BaseEntity {
    /**
     * 标题名
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 本业务名称
     */
    public static final String BUSINESS_NAME = "公告";
}