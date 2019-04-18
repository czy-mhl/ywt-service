package com.yiwei.ywt.businessProcess.checkWaterMeter.model;

import com.yiwei.ywt.framework.model.BaseEntity;
import lombok.Data;


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
}