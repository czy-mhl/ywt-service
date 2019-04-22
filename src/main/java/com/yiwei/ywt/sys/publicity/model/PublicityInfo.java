package com.yiwei.ywt.sys.publicity.model;

import com.yiwei.ywt.framework.model.BaseEntity;
import lombok.Data;
import lombok.ToString;

/**
 * @description: 动态公告实体类
 * 对应表 t_publicity_info
 * @author: czy
 * @date: 2019-04-22 16:04
 * @version: 1.0.0
 */
@Data
@ToString
public class PublicityInfo extends BaseEntity {
    /**
     * 类型
     */
    private String Type;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String info;
    /**
     * 宣传图片
     */
    private String pictureUrl;
}
