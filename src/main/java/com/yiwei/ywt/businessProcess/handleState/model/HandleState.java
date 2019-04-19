package com.yiwei.ywt.businessProcess.handleState.model;

import com.yiwei.ywt.framework.model.BaseEntity;
import lombok.Data;


/**
 * 办理进度业务 实体类
 * 数据库表：t_handle_state
 * @author xk
 * @version 1.0.0
 * @date 2019/04/19
 */
@Data
public class HandleState extends BaseEntity {
    /**
     * 户号
     */
    private String familyNumber;
    /**
     *业务类型（名）
     */
    private String businessName;
    /**
     *业务办理状态（0=正在审核，1=正在办理中，2=办理完成）
     */
    private Integer businessState;
    /**
     *申请人姓名
     */
    private String applyName;
    /**
     *申请人联系方式
     */
    private String applyMobile;
    /**
     *申请人证件类型
     */
    private String applyIdType;
    /**
     *申请人证件号
     */
    private String applyIdCard;
    /**
     *申请原因
     */
    private String applyReason;
    /**
     *申请区域
     */
    private String applyArea;
}