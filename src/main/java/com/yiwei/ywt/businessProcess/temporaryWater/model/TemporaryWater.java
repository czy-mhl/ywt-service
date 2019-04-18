/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TemporaryWater
 * Author:   XXXXXXX
 * Date:     2019/4/16 17:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.yiwei.ywt.businessProcess.temporaryWater.model;

import com.yiwei.ywt.framework.model.BaseEntity;
import lombok.Data;

/**
 * 临时施工用水业务 实体类
 * 数据库表：t_temporary_water
 * @author xk
 * @version 1.0.0
 * @date 2019/04/18
 */
@Data
public class TemporaryWater extends BaseEntity {

    /**
     * 用户类型
     */
    private String customerType;
    /**
     * 业主名称
     */
    private String ownerName;
    /**
     * 业主手机
     */
    private String ownerMobile;
    /**
     * 所属区域
     */
    private String area;
    /**
     * 用水地址
     */
    private String waterAddress;
    /**
     * 单位证件类型
     */
    private String companyType;
    /**
     * 统一社会信用代码
     */
    private String creditCode;
    /**
     * 法人代表名称
     */
    private String corporateRepresenName;
    /**
     * 法人证件号码
     */
    private String corporateRepresenIdCard;
    /**
     * 经办人
     */
    private String managerName;
    /**
     * 经办人电话
     */
    private String managerMobile;
    /**
     * 联系邮箱
     */
    private String managerEmail;
    /**
     * 发票类型
     */
    private String invoiceType;
    /**
     * 营业执照原件或复印件加盖公章（三证合一）
     */
    private String businessLicenseImage;
    /**
     * 法人身份证正、反面或复印件加盖公章
     */
    private String corporateRepresenIdCardImage;
    /**
     * 用水地块的土地归属相关文件原件或复印件加盖公章
     */
    private String landOwnershipImage;
    /**
     * 授权委托、经办人有效身份证正、反（护照提供内页）
     */
    private String managerIdCardImage;
    /**
     * 其它图片
     */
    private String otherImage;
    /**
     * 手机验证码
     */
    private String mobileCode;
}
