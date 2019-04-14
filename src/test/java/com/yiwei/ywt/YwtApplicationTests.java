package com.yiwei.ywt;

import com.yiwei.ywt.sys.menu.controller.SysMenuController;
import com.yiwei.ywt.sys.menu.model.SysMenu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YwtApplicationTests {
    @Autowired
    private SysMenuController sysMenuController;
    @Test
    public void add() {
        SysMenu sysMenu = new SysMenu();
        sysMenu.setMenuName("业务流程");
        sysMenu.setMenuCode("00044");
        sysMenu.setMenuIcon("/004_4");
        sysMenu.setMenuUrl("/004/004");
        sysMenu.setRequestUri("/004/004");
        sysMenu.setSortIndex(4);
        sysMenu.setParentId(352L);
        sysMenu.setModuleId(0L);
        sysMenu.setMenuLevel(2);
        sysMenu.setIsLastOne(2);
        sysMenu.setDescription("服务菜单");
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

}
