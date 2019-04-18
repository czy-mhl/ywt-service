package com.yiwei.ywt.waterCost.myRecord.model;

import com.yiwei.ywt.framework.model.BaseEntity;
import lombok.Data;
/**
 * 开票信息 实体类 </p>
 * 数据库表：T_MY_BILLING_INFORMATION
 * @author czy
 * @version 1.0.0
 * @date 2019/04/18 15:54
 */
@Data
public class BillingInformation extends BaseEntity {
    /**
     * 户号  开票名称
     */
    private String familyName;
    /**
     * 户名
     */
    private String familyCode;
    /**
     * 地址
     */
    private String userWaterAddress;
    /**
     * 开票类型
     */
    private String billingInformationType;
    /**
     * 纳税人识别号
     */
    private String taxpayersRegistrationNumber;
    /**
     * 注册地址
     */
    private String registerAddress;
    /**
     * 企业电话
     */
    private String tel;
    /**
     * 开户银行
     */
    private String openBack;
    /**
     * 银行账号
     */
    private String backAccount;
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 发票通账号
     */
    private String billingInformationAccount;
    /**
     * 预留手机
     */
    private String reservedPhone;


}
