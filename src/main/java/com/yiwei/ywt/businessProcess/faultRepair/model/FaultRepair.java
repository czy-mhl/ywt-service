package com.yiwei.ywt.businessProcess.faultRepair.model;

import com.yiwei.ywt.framework.model.BaseEntity;
import lombok.Data;
/**
 * 故障报修业务 实体类
 * 数据库表：t_fault_repair
 * @author xk
 * @version 1.0.0
 * @date 2019/04/18
 */
@Data
public class FaultRepair extends BaseEntity {
    /**
     * 户号
     */
    private String familyNumber;
    /**
     * 联系人姓名
     */
    private String contactsName;
    /**
     * 联系人手机
     */
    private String contactsMobile;
    /**
     * 报修地址
     */
    private String repairAddress;
    /**
     * 所需资料证件上传（图片）
     */
    private String otherImage;
}