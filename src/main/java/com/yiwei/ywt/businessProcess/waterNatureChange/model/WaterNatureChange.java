package com.yiwei.ywt.businessProcess.waterNatureChange.model;

import com.yiwei.ywt.framework.model.BaseEntity;
import lombok.Data;

/**
 * 用水性质变更业务 实体类
 * 数据库表：t_water_nature_change
 * @author xk
 * @version 1.0.0
 * @date 2019/04/18
 */
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