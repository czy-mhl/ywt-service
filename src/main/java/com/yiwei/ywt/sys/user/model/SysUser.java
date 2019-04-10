package com.yiwei.ywt.sys.user.model;

import lombok.Data;

@Data
public class SysUser {

    private Long id;

    private String mobile;

    private String password;

    private String name;

    private String roleName;

    private String roleId;

    private Integer type;

    private Integer status;

    private String systemId;

    private String createId;

    private String lastLoginIp;

    private String lastLoginTime;

    private String createTime;

    private String lastUpdateTime;

    private Integer delFlag;

    private String description;

}