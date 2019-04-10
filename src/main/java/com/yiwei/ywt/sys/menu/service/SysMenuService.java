package com.yiwei.ywt.sys.menu.service;





import com.yiwei.ywt.sys.menu.model.SysMenu;


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




    
}
