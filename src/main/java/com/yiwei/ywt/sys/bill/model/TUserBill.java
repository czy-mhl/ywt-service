package com.yiwei.ywt.sys.bill.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class TUserBill {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 关联用户ID
     */
    private Long userId;

    /**
     * 账单月份
     */
    private String billMonth;

    /**
     * 上次抄表
     */
    private String lastRead;

    /**
     * 本次抄表
     */
    private String thisRead;

    /**
     * 上次到度
     */
    private Long lastArrival;

    /**
     * 本次到度
     */
    private Long thisArrival;

    /**
     * 抄表情况
     */
    private String readSituation;

    /**
     * 用水量
     */
    private Long waterConsumption;

    /**
     * 自来水费
     */
    private Double waterRates;

    /**
     * 污水费
     */
    private Double sewageCharge;

    /**
     * 垃圾费
     */
    private Double garbageCharge;

    /**
     * 违约金
     */
    private Double penalty;

    /**
     * 非居名污水单价
     */
    private Double nonResidentPrice;

    /**
     * 工商用水单价
     */
    private Double businessCirclesPrice;

    /**
     * 本月账单总额
     */
    private Double mouthTotal;

}