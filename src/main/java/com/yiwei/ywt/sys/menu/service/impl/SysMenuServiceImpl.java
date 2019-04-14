package com.yiwei.ywt.sys.menu.service.impl;


import com.yiwei.ywt.sys.menu.dao.SysMenuMapper;
import com.yiwei.ywt.sys.menu.model.SysMenu;
import com.yiwei.ywt.sys.menu.service.SysMenuService;

import com.yiwei.ywt.sys.role.dao.SysRoleMapper;
import com.yiwei.ywt.sys.role.model.SysRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;

	
	/**
     * 添加菜单
     * @param sysMenu           菜单对象
     * @return
     */
    public SysMenu addEntity(SysMenu sysMenu) {
        return 0<this.sysMenuMapper.insert(sysMenu)?sysMenu:null;
    }

    /**
     * 修改菜单
     * @param sysMenu           菜单对象
     * @return
     */
    public boolean editEntity(SysMenu sysMenu) {
        return 0<this.sysMenuMapper.update(sysMenu);
    }

    /**
     * 删除菜单
     * @param id                菜单主键ID
     * @return
     */
    public boolean deleteEntityMenu(Long id) {
        return 0<this.sysMenuMapper.delete(id);
    }

    /**
     * 获取菜单列表
     * @return
     */
    public List<SysMenu> selectMenuList() {
        List<SysMenu> menu000 = sysMenuMapper.selectMenuByParentId(0L);
        return selectReturn(menu000);
    }

    /**
     * 根据角色权限获取角色拥有的菜单
     * @param roleId
     * @return
     */
    @Override
    public List<SysMenu> selectMenuListByRoleId(Long roleId) {
        if(roleId != null) {
            SysRole sysRole = sysRoleMapper.getEntityById(roleId);
            if (sysRole!=null) {
                List<SysMenu> menus = new ArrayList<>();
                List<SysMenu> menu000 = sysMenuMapper.selectMenuByParentId(0L);
                for(SysMenu sysMenu : menu000){
                    if(sysRole.getRoleMenus().contains(sysMenu.getId()+",")){
                        menus.add(sysMenu);
                    }
                }
                return selectReturnByRoleId(menus,sysRole.getRoleMenus());
            }
        }
        return null;
    }

    /**
     * 无权限过滤
     * @param sysMenuList
     * @return
     */
    public List<SysMenu> selectReturn(List<SysMenu> sysMenuList) {
        for (SysMenu sysMenu : sysMenuList){
            Long parentId = sysMenu.getId();
            List<SysMenu> menu111 = sysMenuMapper.selectMenuByParentId(parentId);
            sysMenu.setSubMenuList(menu111);
            if(menu111 != null && menu111 .size()>0){
                selectReturn(menu111);
            }else{
                continue;
            }
        }
        return sysMenuList;
    }

    /**
     * 权限过滤
     * @param sysMenuList
     * @param roleMenus
     * @return
     */
    public List<SysMenu> selectReturnByRoleId(List<SysMenu> sysMenuList,String roleMenus) {
        for (SysMenu sysMenu : sysMenuList){
            Long id = sysMenu.getId();
            if (roleMenus.contains(id+",")) { //角色拥有此权限
                List<SysMenu> menu111 = sysMenuMapper.selectMenuByParentId(id);
                sysMenu.setSubMenuList(menu111);
                if(menu111 != null && menu111 .size()>0){
                    selectReturn(menu111);
                }else{
                    continue;
                }
            }
        }
        return sysMenuList;
    }


}
