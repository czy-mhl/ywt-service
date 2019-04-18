package com.yiwei.ywt.businessProcess.waterNatureChange.model;

import com.yiwei.ywt.framework.model.BaseEntity;
import lombok.Data;


@Data
public class WaterNatureChange extends BaseEntity {
    /**
     * 户号
     */
    private String familyNumber;
    /**
     * 办理人
     */
    private String transactor;
    /**
     * 办理人手机
     */
    private String transactorMobile;
    /**
     * 申请原因
     */
    private String applyReason;
    /**
     * 户主身份证
     */
    private String idCardImage;
    /**
     * 个人签名
     */
    private String peopleAutographImage;
    /**
     * 房产证明等其它资料
     */
    private String otherImage;
}