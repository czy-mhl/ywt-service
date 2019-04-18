package com.yiwei.ywt.waterCost.myRecord.model;

import lombok.Data;

import java.math.BigDecimal;
/**
 * 我的档案 实体类 </p>
 * 数据库表：T_MY_RECORD_INFO
 * @author czy
 * @version 1.0.0
 * @date 2019/04/16 15:54
 */
@Data
public class MyRecordInfo {

    private String familyName;

    private String familyCode;

    private String userWaterAddress;

    private String waterMeterDiameter;

    private String readMeterPeriod;

    private String useWaterType;

    private BigDecimal waterUnitPrice;

    private String dirtWaterType;

    private BigDecimal dirtWaterUnitPrice;

    private String proportion;

    private BigDecimal garbageCost;

    private String agencyDeductBack;

    private String agencyDeductAccount;

    private String mobilePhone;

    private String serviceStructure;

    private String salesman;

    private String salesmanPhone;

}