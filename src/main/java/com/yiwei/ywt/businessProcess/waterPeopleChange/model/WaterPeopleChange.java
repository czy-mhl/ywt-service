package com.yiwei.ywt.businessProcess.waterPeopleChange.model;

import com.yiwei.ywt.framework.model.BaseEntity;
import lombok.Data;

/**
 * 用水人口变更业务 实体类
 * 数据库表：t_water_people_change
 * @author xk
 * @version 1.0.0
 * @date 2019/04/18
 */
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
    /**
     * 本业务名称
     */
    public static final String BUSINESS_NAME = "用水人口变更";
}
