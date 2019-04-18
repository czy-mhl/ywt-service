package com.yiwei.ywt.businessProcess.checkWaterMeter.model;

import com.yiwei.ywt.framework.model.BaseEntity;
import lombok.Data;


@Data
public class CheckWaterMeter extends BaseEntity {

    private String familyNumber;

    private String checkWaterMeterReason;

    private String transactor;

    private String transactorMobile;

    private String idCardImage;
}