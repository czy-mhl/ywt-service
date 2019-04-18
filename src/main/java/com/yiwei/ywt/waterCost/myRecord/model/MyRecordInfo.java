package com.yiwei.ywt.waterCost.myRecord.model;

import com.yiwei.ywt.framework.model.BaseEntity;
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
public class MyRecordInfo extends BaseEntity {
    /**
     * 户名
     */
    private String familyName;
    /**
     * 户号
     */
    private String familyCode;
    /**
     * 用水地址
     */
    private String userWaterAddress;
    /**
     * 水表口径
     */
    private String waterMeterDiameter;
    /**
     * 抄表周期
     */
    private String readMeterPeriod;
    /**
     * 用水类型
     */
    private String useWaterType;
    /**
     * 水费单价
     */
    private BigDecimal waterUnitPrice;
    /**
     * 污水类型
     */
    private String dirtWaterType;
    /**
     * 污水单价
     */
    private BigDecimal dirtWaterUnitPrice;
    /**
     * 占比
     */
    private String proportion;
    /**
     * 垃圾费
     */
    private BigDecimal garbageCost;
    /**
     * 代扣银行
     */
    private String agencyDeductBack;
    /**
     * 代扣账号
     */
    private String agencyDeductAccount;
    /**
     * 短信定制手机
     */
    private String mobilePhone;
    /**
     * 服务机构
     */
    private String serviceStructure;
    /**
     * 营销员
     */
    private String salesman;
    /**
     * 营销员手机
     */
    private String salesmanPhone;
    /**
     * 开票信息
     */
    private BillingInformation billingInformation;

}