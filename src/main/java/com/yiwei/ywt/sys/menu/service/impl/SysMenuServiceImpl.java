package com.yiwei.ywt.sys.menu.service.impl;


import com.yiwei.ywt.sys.menu.dao.SysMenuMapper;
import com.yiwei.ywt.sys.menu.model.SysMenu;
import com.yiwei.ywt.sys.menu.service.SysMenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

	
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





/*

    public void createListTree(Long systemId, Long moduleId, List<SysMenu> sysMenus){
        if(!sysMenus.isEmpty() && sysMenus.size()>0){
            for (SysMenu menu : sysMenus){
                List<SysMenu> sysMenuList = this.sysMenuMapper.selectListBySystemId(systemId, moduleId, menu.getId());
                menu.setSubMenuList(sysMenuList);
                createListTree(systemId, moduleId, sysMenuList);
            }
        }
    }


    */
/**
     * 验证菜单编码是否存在
     * @menuCode                菜单编码
     * @return
     *//*

    public boolean checkMenuCodeIsExist(String menuCode){
        SysMenu sysMenu = this.sysMenuMapper.getEntityByMenuCode(menuCode);
        return sysMenu != null;
    }

    */
/**
     * 查询菜单列表
     * @param systemId          系统ID
     * @return
     *//*

    public List<SysMenu> selectList(Long systemId){
        //先根据sytemId得到菜单集合
        List<SysMenu> sysMenus = this.sysMenuMapper.selectList(systemId);
        //然后再判断末级菜单，给末级菜单设置fundId
        List<SysMenu> lastMenus = this.getLastMenuNodes(sysMenus);
        for(SysMenu sysMenu : sysMenus){
            for(SysMenu lastMenu : lastMenus){
                if(sysMenu.getId().longValue() == lastMenu.getId().longValue()){
                    List<SysMetadata> sysFuncList = this.sysMetadataMapper.getMetadataListByMenuId(sysMenu.getId());
                    sysMenu.setIsLastOne(true);
                }
            }
        }
        return sysMenus;
    }

    */
/**
     * 根据传入的菜单集合得到所有的末级菜单集合
     * @param menuSystemList
     * @return
     *//*

    private List<SysMenu> getLastMenuNodes(List<SysMenu> menuSystemList){
        List<SysMenu> lastMenus = new ArrayList<>();
        if(menuSystemList != null){
            for(SysMenu mobj : menuSystemList){
                List<SysMenu> childMenuList = this.findChildMenuByParentId(mobj.getId(),menuSystemList);
                if(childMenuList.size() == 0){
                    mobj.setIsLastOne(true);
                    lastMenus.add(mobj);
                }
            }
        }
        return lastMenus;
    }

    */
/**
     * 根据多角色得到并封装对应的菜单和完成的菜单结构
     * @param roleLsit
     * @return
     *//*

    public HashMap<String, List<SysMenu>> conMenu(List<SysUserRole> roleLsit, long systemId){
        List<Long> roleIdList = new ArrayList<Long>();
        for(SysUserRole role : roleLsit){
            roleIdList.add(role.getRoleId());
        }
        List<SysMenu> menuAllList = this.sysMenuMapper.getEntityByMenuAllInfo(systemId);
        List<SysMenu> menuByRoleList = this.sysMenuMapper.getEntityByMenuRoleIds(roleIdList,systemId);
        //多角色下的菜单排重
        menuByRoleList = this.distinctMenu(menuByRoleList);
        HashMap<String, List<SysMenu>> map = new HashMap<String, List<SysMenu>>();
        map.put("menuAllList",menuAllList);
        map.put("menuByRoleList",menuByRoleList);
        return map;
    }

    //多角色下的菜单排重
    private List<SysMenu> distinctMenu(List<SysMenu> menuByRoleList){
        List<SysMenu> distinctList = new ArrayList<SysMenu>();
        HashMap<Long, SysMenu> map = new HashMap<Long, SysMenu>();
        if(menuByRoleList != null){
            for(SysMenu obj : menuByRoleList){
                map.put(obj.getId(), obj);
            }
        }
        Iterator itr = map.keySet().iterator();
        while (itr.hasNext()) {
            Long key = (Long) itr.next();
            distinctList.add(map.get(key));
        }
        return distinctList;
    }

    */
/**
     * 采用递归方式得到每个末级菜单对应的父节点直至根节点的集合
     * @param menuAllList
     * @param menuByRoleList
     * @param childMenuList
     * @return
     *//*

    public List<SysMenu> assembleMenu(List<SysMenu> menuAllList, List<SysMenu> menuByRoleList, List<SysMenu> childMenuList, HashMap<Long,SysMenu> sysMenuHashMap){
        if(childMenuList == null){
            childMenuList = menuByRoleList;
        }
        for(SysMenu childMenu : childMenuList){
            SysMenu parentMenu = this.findParentByChild(childMenu.getId(), menuAllList);
            sysMenuHashMap.put(childMenu.getId(),childMenu);
            sysMenuHashMap.put(parentMenu.getId(),parentMenu);
            List<SysMenu> parentMenuList = this.findParentListByChildList(childMenuList, menuAllList);
            if(parentMenu.getParentId() != -1L){
                this.assembleMenu(menuAllList, parentMenuList,null, sysMenuHashMap);
            }else{
                sysMenuHashMap.put(childMenu.getId(),childMenu);
            }
        }
        List<SysMenu> list = new ArrayList<>();
        Iterator itr = sysMenuHashMap.keySet().iterator();
        while (itr.hasNext()) {
            Long key = (Long) itr.next();
            list.add(sysMenuHashMap.get(key));
        }
        return list;
    }

    //根据子级菜单寻找父级菜单
    private SysMenu findParentByChild(Long childId, List<SysMenu> menuAllList){
        SysMenu parentMenu = null;
        if(menuAllList != null && childId != null){
            for(int i=0; i<menuAllList.size(); i++){
                if(childId.longValue() == menuAllList.get(i).getId()){
                    parentMenu = menuAllList.get(i);
                    break;
                }
            }
        }
        return parentMenu;
    }
    
    
    //\根据子级菜单的集合寻找父级菜单的集合
    private List<SysMenu> findParentListByChildList(List<SysMenu> childMenuList, List<SysMenu> menuAllList){
        List<SysMenu> parentMenuList = new ArrayList<SysMenu>();
        if(menuAllList != null && childMenuList != null){
            for(int i=0; i<childMenuList.size(); i++){
                for(int j=0; j<menuAllList.size(); j++){
                    if(childMenuList.get(i).getParentId().longValue() == menuAllList.get(j).getId()){
                        parentMenuList.add(menuAllList.get(j));
                    }
                }
            }
            //排重
            parentMenuList = this.distinctMenu(parentMenuList);
        }
        return parentMenuList;
    }

    //根据父级ID寻找子级菜单
    private List<SysMenu> findChildMenuByParentId(Long parentId, List<SysMenu> menuAllList){
        List<SysMenu> childMenuList = new ArrayList<SysMenu>();
        if(menuAllList != null){
            for(SysMenu menu : menuAllList){
                if(parentId.longValue() == menu.getParentId().longValue()){
                    childMenuList.add(menu);
                }
            }
        }
        return childMenuList;
    }

    */
/**
     * 采用递归方式组装完整的菜单树
     * @param sysMenu
     * @param menuId
     * @param menuList：特别说明，此menuList一定是完整的多角色下所拥有的完整的菜单集合
     * @return
     *//*

    public SysMenu assembleMenuTree(SysMenu sysMenu, Long menuId, List<SysMenu> menuList){
        List<SysMenu> menuChildList1 = this.findChildMenuByParentId(menuId, menuList);
        List<SysMenu> sysMenuTreeNodes = new ArrayList<SysMenu>();
        for(SysMenu menu : menuChildList1){
            List<SysMenu> menuChildList2 = this.findChildMenuByParentId(menu.getId(), menuList);
            if(menuChildList2 != null && !menuChildList2.isEmpty()){
                assembleMenuTree(menu, menu.getId(), menuList);
            }
            sysMenuTreeNodes.add(menu);
        }
        sysMenu.setSubMenuList(sysMenuTreeNodes);
        return sysMenu;
    }

    public SysMenu loadMenuTree(List<SysUserRole> roleList,long systemId){
        HashMap<String, List<SysMenu>> map = this.conMenu(roleList,systemId);
        List<SysMenu> menuList = this.assembleMenu(map.get("menuAllList"), map.get("menuByRoleList"), null, new HashMap<Long, SysMenu>());
        SysMenu sysMenu = new SysMenu();
        SysMenu sysMenuObj = this.assembleMenuTree(sysMenu, -1L, menuList);
//        System.out.println(sysMenuObj);
        return sysMenuObj;
    }
*/

	
}
