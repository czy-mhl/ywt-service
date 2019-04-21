package com.yiwei.ywt.sys.serviceInformation.model;

import com.yiwei.ywt.framework.model.BaseEntity;
import lombok.Data;

/**
 * 水价标准 实体类
 * 数据库表：t_water_price_standar
 *
 * @author xk
 * @version 1.0.0
 * @date 2019/04/21
 */
@Data
//@EqualsAndHashCode(callSuper = true)
public class WaterPriceStandar extends BaseEntity {
    /**
     *标题名
     */
    private String title;
    /**
     *内容
     */
    private String content;
    /**
     *计费标准图片
     */
    private String picture;
    /**
     * 本业务名称
     */
    public static final String BUSINESS_NAME = "水价标准";
}