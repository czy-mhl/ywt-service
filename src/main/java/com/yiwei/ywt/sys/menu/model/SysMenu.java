package com.yiwei.ywt.sys.menu.model;



import com.yiwei.ywt.framework.model.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 系统菜单 实体类 </p>
 * 数据库表：T_SYS_MENU
 *
 * @author czy
 * @version 1.0.0
 * @date 2016/11/24 15:54
 */
@Data
public class SysMenu extends BaseEntity implements Serializable {

    /**
     * 系统菜单名称
     */
    private String menuName;

    /**
     * 系统菜单编码
     */
    private String menuCode;

    /**
     * 系统菜单图标
     */
    private String menuIcon;

    /**
     * 系统菜单访问路径
     */
    private String menuUrl;

    /**
     * 系统菜单请求路径
     */
    private String requestUri;

    /**
     * 系统菜单排序
     */
    private Integer sortIndex;

    /**
     * 父级菜单ID
     */
    private Long parentId;

    /**
     * 系统ID
     */
    private Long systemId;

    /**
     * 模块ID
     */
    private Long moduleId;

    /**
     * 系统菜单层级
     */
    private Integer menuLevel;

    /**
     * 是否启用(1=启用，0=禁用)
     */
    private String description;

    /**
     * 系统菜单名称
     */
    private Boolean enabled;

    /**
     * 删除标记(1=已删除，0=未删除)
     */
    private Boolean delFlag;

    /**
     * 是否是末级菜单
     */
    private Boolean isLastOne;

    /**
     * 父级菜单
     */
    private SysMenu parentMenu;

    /**
     * 子菜单集合
     */
    private List<SysMenu> subMenuList;



}
