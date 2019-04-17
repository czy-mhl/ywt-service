/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BusinessWater
 * Author:   XXXXXXX
 * Date:     2019/4/16 16:07
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.yiwei.ywt.businessProcess.businessCirclesNew.model;

import com.yiwei.ywt.framework.model.BaseEntity;
import lombok.Data;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author XXXXXXX
 * @create 2019/4/16
 * @since 1.0.0
 */

@Data
public class BusinessWater extends BaseEntity {
    /**
     * 用户类型
     */
    private String customerType;
    /**
     * 业务类型
     */
    private String businessType;
    /**
     * 业主名称
     */
    private String ownerName;
    /**
     * 所属区域
     */
    private String area;
    /**
     * 用水地址
     */
    private String waterAddress;
    /**
     * 业主手机
     */
    private String ownerMobile;
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
     * 法人有效身份证件号码
     */
    private String corporateRepresenIdCard;
    /**
     * 用水性质
     */
    private String waterType;
    /**
     * 经办人
     */
    private String managerName;
    /**
     * 联系邮箱
     */
    private String managerEmail;
    /**
     * 经办人电话
     */
    private String managerMobile;
    /**
     * 开票类型
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
