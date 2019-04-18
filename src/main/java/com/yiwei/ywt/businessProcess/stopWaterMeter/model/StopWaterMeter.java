package com.yiwei.ywt.businessProcess.stopWaterMeter.model;


import com.yiwei.ywt.framework.model.BaseEntity;
import lombok.Data;
/**
 * 暂停申请业务 实体类
 * 数据库表：t_stop_water_meter
 * @author xk
 * @version 1.0.0
 * @date 2019/04/18
 */
@Data
public class StopWaterMeter extends BaseEntity {
    /**
     * 户号
     */
    private String familyNumber;
    /**
     * 户主手机号码
     */
    private String ownerMobile;
    /**
     * 办理人
     */
    private String transactor;
    /**
     * 办理人身份证
     */
    private String transactorIdCard;
    /**
     * 办理人手机
     */
    private String transactorMobile;
    /**
     * 申请原因
     */
    private String applyReason;
    /**
     * 户主身份证
     */
    private String idCardImage;
    /**
     * 办理人身份证
     */
    private String transactorIdCardImage;
}