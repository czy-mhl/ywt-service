package com.yiwei.ywt.sys.user.model;

import com.yiwei.ywt.framework.model.BaseEntity;
import com.yiwei.ywt.sys.menu.model.SysMenu;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 系统用户 实体类</p>
 * 数据库表：T_SYS_USER
 *
 * @author czy
 * @version 1.0.0
 * @date 2019/04/10 18:24
 */
@Data
public class SysUser extends BaseEntity implements Serializable {
    /**
     * 用户手机
     */
    private String mobile;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 微信OPENID
     */
    private String wxOpenId;
    /**
     * 推荐码
     */
    private String inviteCode;
    /**
     * 用户名称
     */
    private String name;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 用户类型
     */
    private Integer type;
    /**
     * 子菜单集合
     */
    private List<SysMenu> subMenuList;



}