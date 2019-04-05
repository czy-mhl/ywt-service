package com.yiwei.ywt.user.model;

import lombok.Data;

import java.util.Date;

@Data
public class SysUser {
    private Long id;

    private String account;

    private String password;

    private Long systemId;

    private Long orgId;

    private Long employeeId;

    private Boolean enabled;

    private String lastLoginIp;

    private Date lastLoginTime;

    private Date createTime;

    private Date lastUpdateTime;

    private Boolean delFlag;

    private Boolean isReal;

    private String name;

    private String idcard;

    private String mobile;

    private String tel;

    private String eMail;

    private Integer type;

    private Boolean sex;

    private String address;

    private String employeeHead;

    private String description;

    private String proCode;

    private String proName;

    private String cityCode;

    private String cityName;

    private String countyCode;

    private String countyName;

    private Long deptId;

    private String deptName;

    private String orgName;

    private Integer category;

    private Integer orgType;

    private String orgDuties;

    private Long unitId;

    private String unitName;

    private String unitDuties;

    private String unitAddress;

    private String education;

    private String professional;

    private String workContent;

    private String evidenced;

    private Integer subject;

    private String political;

    private String politicalDesc;

    private String national;

    private String nationalDesc;

    private Integer status;

    private String annexPath;

    private Long expertsId;

    private Long createId;

    private String otherOrg;

    private String qkUnitName;

    private String fileInfoId;

}