package com.yiwei.ywt.waterCost.bill.model;

import com.yiwei.ywt.framework.model.BaseEntity;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 水费账单 实体类 </p>
 * 数据库表：T_WATER_BILL
 * @author czy
 * @version 1.0.0
 * @date 2019/04/16 15:54
 */
@Data
@ToString
public class WaterBill extends BaseEntity {
    /**
     * 户号
     */
    private String familyCode;
    /**
     * 账单月份
     */
    private Integer billMonth;
    /**
     * 账单列表开始月份
     */
    private Integer startBillMonth;
    /**
     * 账单列表结束月份
     */
    private Integer endBillMonth;

    /**
     * 上次抄表日期
     */
    private String lastReadDate;

    /**
     * 本次抄表日期
     */
    private String thisReadDate;

    /**
     * 上次到度
     */
    private Integer lastArrival;

    /**
     * 本次到度
     */
    private Integer thisArrival;

    /**
     * 抄表情况
     */
    private String readSituation;

    /**
     * 用水量
     */
    private Integer waterConsumption;

    /**
     * 自来水费
     */
    private BigDecimal waterCost;

    /**
     * 污水费
     */
    private BigDecimal dirtWaterCost;

    /**
     * 垃圾费
     */
    private BigDecimal garbageCost;

    /**
     * 违约金
     */
    private BigDecimal penalty;
    /**
     * 合计金额
     */
    private BigDecimal totalMoney;
    /**
     * 缴费状态
     */
    private String paymentStatus;
    /**
     * 缴费日期
     */
    private Date paymentDate;
    /**
     * 缴费渠道
     */
    private String paymentUrl;
    /**
     * 缴费方式
     */
    private String paymentWay;

    /**
     * 用水类型  工商用水  居民用水
     */
    private String useWaterType;
    /**
     * 水费单价
     */
    private BigDecimal waterUnitPrice;

    /**
     * 污水费类型 居民污水  非居民污水
     */
    private String dirtWaterType;
    /**
     * 污水单价
     */
    private BigDecimal dirtWaterUnitPrice;

}