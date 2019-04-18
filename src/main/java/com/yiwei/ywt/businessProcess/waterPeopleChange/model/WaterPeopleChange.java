package com.yiwei.ywt.businessProcess.waterPeopleChange.model;

import com.yiwei.ywt.framework.model.BaseEntity;
import lombok.Data;


@Data
public class WaterPeopleChange extends BaseEntity {
    /**
     * 户号
     */
    private String familyNumber;
    /**
     * 申请人口数
     */
    private Integer applyPeopleNumber;
    /**
     * 办理人手机
     */
    private String transactorMobile;
    /**
     * 户主身份证
     */
    private String idCardImage;
    /**
     * 证件类型
     */
    private String idType;
    /**
     * 证件号码
     */
    private String idCard;
    /**
     * 证件上传
     */
    private String documentUpload;
}