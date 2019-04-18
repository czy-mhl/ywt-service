package com.yiwei.ywt.businessProcess.businessChange.model;

import com.yiwei.ywt.framework.model.BaseEntity;
import lombok.Data;
/**
 * 工商用水改移装业务 实体类
 * 数据库表：t_business_change
 *
 * @author xk
 * @version 1.0.0
 * @date 2019/04/18
 */
@Data
public class BusinessChange extends BaseEntity {
    /**
     * 户号
     */
    private String familyNumber;
    /**
     *户名
     */
    private String familyName;
    /**
     *用水地址
     */
    private String waterAddress;
    /**
     *改移原因
     */
    private String changeReason;
    /**
     *证件类型
     */
    private String idType;
    /**
     *证件号码
     */
    private String idCard;
    /**
     *经办人姓名
     */
    private String managerName;
    /**
     *经办人电话
     */
    private String managerMobile;
    /**
     *联系邮箱
     */
    private String managerEmail;
    /**
     *发票类型
     */
    private String invoiceType;
    /**
     *营业执照原件或复印件加盖公章（三证合一）
     */
    private String businessLicenseImage;
    /**
     *法人身份证正、反面或复印件加盖公章
     */
    private String corporateRepresenIdCardImage;
    /**
     *授权委托、经办人有效身份证正、反（护照提供内页）
     */
    private String managerIdCardImage;
    /**
     *其它图片
     */
    private String otherImage;
    /**
     *手机验证码
     */
    private String mobileCode;
}