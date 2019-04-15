package com.yiwei.ywt.businessProcess.FileErrorDeclaration.model;

import com.yiwei.ywt.framework.model.BaseEntity;
import lombok.Data;

/**
 * 档案错误申报 实体类 </p>
 * 数据库表：T_FILE_ERROR_INFO
 *
 * @author czy
 * @version 1.0.0
 * @date 2019/04/15 15:54
 */
@Data
public class FileErrorInfo extends BaseEntity {

    /**
     * 户号
     */
    private String familyCode;
    /**
     * 用水地址
     */
    private String useWaterAddress;
    /**
     * 联系人
     */
    private String theLinkman;
    /**
     * 手机号
     */
    private String mobilePhone;
    /**
     * 差错说明附件   多个 url 用 , 号隔开
     */
    private String errorDescriptionAccessoryUrl;
    /**
     * 证件附件  多个 url 用 , 号隔开
     */
    private String papersAccessoryUrl;
    /**
     * 其他附件  多个 url 用 , 号隔开
     */
    private String otherAccessoryUrl;
    /**
     * 验证吗
     */
    private String checkCode;

}
