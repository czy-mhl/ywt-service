package com.yiwei.ywt.sys.serviceInformation.model;

import com.yiwei.ywt.framework.model.BaseEntity;
import lombok.Data;
/**
 * 交费方式业务 实体类
 * 数据库表：t_water_price_standar
 *
 * @author xk
 * @version 1.0.0
 * @date 2019/04/22
 */
@Data
public class PayMode extends BaseEntity {
    /**
     * 标题名
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 营业厅名称
     */
    private String businessHallName;
    /**
     * 营业厅地址
     */
    private String businessHallAddress;
    /**
     * 营业厅热线电话
     */
    private String businessHallTelephone;
    /**
     * 营业厅地址图片
     */
    private String picture;
    /**
     * 本业务名称
     */
    public static final String BUSINESS_NAME = "交费方式";
}