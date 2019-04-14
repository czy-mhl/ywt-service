package com.yiwei.ywt.sys.menu.service;

import com.yiwei.ywt.sys.menu.model.SysMenu;

import java.util.List;


public interface SysMenuService {

    /**
     * 添加菜单
     * @param sysMenu           菜单对象
     * @return
     */
    SysMenu addEntity(SysMenu sysMenu);

    /**
     * 修改菜单
     * @param sysMenu           菜单对象
     * @return
     */
    boolean editEntity(SysMenu sysMenu);

    /**
     * 删除菜单
     * @param id                菜单主键ID
     * @return
     */
    boolean deleteEntityMenu(Long id);

    /**
     * 获取菜单列表
     * @return
     */
    List<SysMenu> selectMenuList();
    /**
     * 根据角色id获取菜单列表
     * @param roleId                角色ID
     * @return
     */
    List<SysMenu> selectMenuListByRoleId(Long roleId);




    
}
