package com.yiwei.ywt.sys.role.model;

import com.yiwei.ywt.framework.model.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * 系统角色 实体类</p>
 * 数据库表：T_ROLE
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
     * 默认展示的系统模块菜单
     */
    private String defaultModuleId;
    /**
     * 角色拥有的菜单
     */
    private String roleMenus;
}
