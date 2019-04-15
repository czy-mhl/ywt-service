package com.yiwei.ywt;

import com.yiwei.ywt.sys.menu.controller.SysMenuController;
import com.yiwei.ywt.sys.menu.mapper.SysMenuMapper;
import com.yiwei.ywt.sys.menu.model.SysMenu;
import com.yiwei.ywt.sys.menu.service.SysMenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuApplicationTests {
    @Autowired
    private SysMenuController sysMenuController;
    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Test
    public void add() {
        SysMenu sysMenu = new SysMenu();
        sysMenu.setMenuName("角色权限修改");
        sysMenu.setMenuCode("00064");
        sysMenu.setMenuIcon("/006_4");
        sysMenu.setMenuUrl("/006/004");
        sysMenu.setRequestUri("/006/004");
        sysMenu.setSortIndex(4);
        sysMenu.setParentId(353L);
        sysMenu.setModuleId(0L);
        sysMenu.setMenuLevel(2);
        sysMenu.setIsLastOne(2);
        sysMenu.setDescription("系统设置");
        sysMenuController.addEntity(sysMenu);
    }
    @Test
    public void edit(){
        SysMenu sysMenu = new SysMenu();
        sysMenu.setMenuName("水费查交");
        sysMenu.setId(350L);
        sysMenu.setMenuCode("0004");
        sysMenu.setMenuIcon("/004");
        sysMenu.setMenuUrl("/004");
        sysMenu.setRequestUri("/004");
        sysMenu.setSortIndex(1);
        sysMenu.setParentId(0L);
        sysMenu.setModuleId(0L);
        sysMenu.setMenuLevel(2);
        sysMenu.setIsLastOne(2);
        sysMenu.setDescription("业务菜单");
       sysMenuController.editEntity(sysMenu);
    }

    @Test
    public void select(){
        System.out.println(sysMenuService.selectMenuListByRoleId(2L));
    }

}
