package com.yiwei.ywt;

import com.yiwei.ywt.sys.role.controller.SysRoleController;
import com.yiwei.ywt.sys.role.model.SysRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleApplicationTests {
    @Autowired
    private SysRoleController sysRoleController;
    @Test
    public void add() {

    }
    @Test
    public void edit(){
        SysRole sysRole = new SysRole();
        sysRole.setId(1L);
        sysRole.setRoleMenus("348,349,350,351,352,354,355,356,357,358,359,360,361,362,363,364,365,366,367,368,369,370,371,372,373,374,375,376,377,378,379,380,381,382,383,384,385,386,387,388,389,");
        sysRoleController.editEntity(sysRole);
    }

    @Test
    public void select(){
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=348 ;i<386;i++){
          stringBuffer.append(i+",");
        }
        System.out.println(stringBuffer.toString());
    }

}
