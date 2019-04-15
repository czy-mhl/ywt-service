package com.yiwei.ywt.businessProcess.diBaoPreferential.model;

import com.yiwei.ywt.framework.model.BaseEntity;
import lombok.Data;
/**
 * 低保优惠业务办理 实体类 </p>
 * 数据库表：T_DIBAO_INFO
 *
 * @author czy
 * @version 1.0.0
 * @date 2019/04/15 15:54
 */
@Data
public class DibaoInfo extends BaseEntity {
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
    private String useWaterAddress;
    /**
     * 办理类别  1 新增  2 复审
     */
    private Integer applyType;
    /**
     * 低保户主名字
     */
    private String familyMainName;

    /**
     * 联系人
     */
    private String theLinkman;
    /**
     * 手机号
     */
    private String mobilePhone;
    /**
     * 身份证号
     */
    private String identityNumber;
    /**
     * 低保金额领取证或特困供养证原件照片url  多个 url 用 , 号隔开
     */
    private String dibaotekunUrl;
    /**
     * 低保户身份证照片url  多张照片 url 用 , 号隔开
     */
    private String identityPictureUrl;
    /**
     * 保障性住房租房合同 url  多个 url 用 , 号隔开
     */
    private String tenancyAgreementFileUrl;


}
