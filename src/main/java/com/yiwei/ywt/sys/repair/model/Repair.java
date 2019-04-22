package com.yiwei.ywt.sys.repair.model;

import com.yiwei.ywt.framework.model.BaseEntity;
import lombok.Data;

/**
 * 报修报漏 实体类
 * 数据库表：t_repair
 *
 * @author xk
 * @version 1.0.0
 * @date 2019/04/22
 */
@Data
public class Repair extends BaseEntity {
    /**
     * 户号
     */
    private String familyNumber;
    /**
     * 报漏报修区域
     */
    private String reportLeakArea;
    /**
     * 报漏报修地址
     */
    private String reportLeakAddress;
    /**
     * 申请人姓名
     */
    private String transactorName;
    /**
     * 申请人手机
     */
    private String transactorMobile;
    /**
     * 申请人电话（选填）
     */
    private String transactorPhone;
    /**
     * 有效证件
     */
    private String idCardImage;
    /**
     * 现场照片
     */
    private String picture;
    /**
     * 报修类别（0=非户主，1=户主）
     */
    private Integer repairType;
    /**
     * 手机验证码（户主）
     */
    private String mobileCode;
    /**
     * 本业务名称
     */
    public static final String BUSINESS_NAME = "报漏报修";
}
