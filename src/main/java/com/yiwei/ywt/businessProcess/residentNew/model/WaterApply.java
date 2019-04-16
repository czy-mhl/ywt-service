package com.yiwei.ywt.businessProcess.residentNew.model;

import com.yiwei.ywt.framework.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Description:
 *
 * @author Longe
 * @since 2019.04.15
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WaterApply extends BaseEntity {
    /**
     * 业主姓名
     */
    private String ownerName;
    /**
     * 所属区域
     */
    private String area;
    /**
     * 用水地址
     */
    private String address;
    /**
     * 业主手机
     */
    private String ownerMobile;
    /**
     * 有效身份证件
     */
    private String idType;
    /**
     * 证件号码
     */
    private String idCard;
    /**
     * 产权证号
     */
    private String ownerCertificateNo;
    /**
     * 用水性质
     */
    private String waterUseType;
    /**
     * 办理说明
     */
    private String description;
    /**
     * 经办人
     */
    private String manager;
    /**
     * 经办人手机号
     */
    private String managerMobile;
    /**
     * 身份证图片地址
     */
    private String idCardImage;
    /**
     * 不动产完整内页图片地址
     */
    private String ownerCertificateImage;
    /**
     * 经办人证件图片地址
     */
    private String managerImage;
}
