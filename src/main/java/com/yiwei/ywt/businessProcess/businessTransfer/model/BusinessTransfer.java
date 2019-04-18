package com.yiwei.ywt.businessProcess.businessTransfer.model;

import com.yiwei.ywt.framework.model.BaseEntity;
import lombok.Data;

/**
 * 工商客户过户业务 实体类
 * 数据库表：t_business_transfer
 *
 * @author xk
 * @version 1.0.0
 * @date 2019/04/18
 */
@Data
public class BusinessTransfer extends BaseEntity {
    /**
     *户号
     */
    private String familyNumber;
    /**
     *用水地址
     */
    private String waterAddress;
    /**
     *新户名
     */
    private String newFamilyName;
    /**
     *产权地址
     */
    private String propertyAddress;
    /**
     *新联系电话
     */
    private String newOwnerMobile;
    /**
     *开票名称
     */
    private String invoiceName;
    /**
     *开票类型
     */
    private String invoiceType;
    /**
     *纳税识别号
     */
    private String taxIdentififationNumber;
    /**
     *注册地址
     */
    private String companyRegistrationAddress;
    /**
     *税务电话
     */
    private String taxPhone;
    /**
     *开户银行
     */
    private String openAccountBank;
    /**
     *银行账号
     */
    private String bankAccount;
    /**
     *收票邮箱
     */
    private String collectTicketsEmail;
    /**
     *其他说明
     */
    private String other;
    /**
     *单位证件类型
     */
    private String companyType;
    /**
     *单位证件号码
     */
    private String companyCard;
    /**
     *产权证号
     */
    private String ownerCertificateno;
    /**
     *经办人
     */
    private String managerName;
    /**
     *经办人手机
     */
    private String managerMobile;
    /**
     *下载确认模板地址
     */
    private String templateAddress;
    /**
     *营业执照原件或复印件加盖公章（三证合一）
     */
    private String businessLicenseImage;
    /**
     *过户业务登记表
     */
    private String transferRegistration;
    /**
     *企业法人有效身份证件正、反面（护照提供内页）
     */
    private String corporateRepresenIdCardImage;
    /**
     *授权委托、经办人有效身份证正、反（护照提供内页）
     */
    private String managerIdCardImage;
    /**
     *手机验证码
     */
    private String mobileCode;
}