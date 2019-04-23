package com.yiwei.ywt.businessProcess.checkWaterMeter.model;

import com.yiwei.ywt.framework.model.BaseEntity;
import lombok.Data;
/**
 * 水表验表申请业务 实体类
 * 数据库表：t_check_water_meter
 * @author xk
 * @version 1.0.0
 * @date 2019/04/18
 */
@Data
public class CheckWaterMeter extends BaseEntity {
    /**
     * 户号
     */
    private String familyNumber;
    /**
     * 验表原因
     */
    private String checkWaterMeterReason;
    /**
     * 办理人
     */
    private String transactor;
    /**
     * 办理人手机
     */
    private String transactorMobile;
    /**
     * 户主身份证
     */
    private String idCardImage;
    /**
     * 本业务名称
     */
    public static final String BUSINESS_NAME = "水表验表申请";
}
