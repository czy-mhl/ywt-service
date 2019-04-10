package com.yiwei.ywt.sys.role.model;

import com.yiwei.ywt.framework.model.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * 系统角色 实体类</p>
 * 数据库表：T_SYS_ROLE
 *
 * @author czy
 * @version 1.0.0
 * @date 2019/04/10 18:24
 */
@Data
public class SysRole extends BaseEntity implements Serializable {

    /**
     * 系统角色名称
     */
    private String roleName;

    /**
     * 系统角色编码
     */
    private String roleCode;

    /**
     * 是否启用(1=启用，0=禁用)
     */
    private Boolean enabled;

    /**
     * 系统角色描述
     */
    private String description;

    /**
     * 系统ID
     */
    private Long systemId;


    /**
     * 删除标记(1=已删除，0=未删除)
     */
    private Boolean delFlag;

    /**
     * 默认展示的系统模块菜单
     */
    private Short defaultModuleId;
}
