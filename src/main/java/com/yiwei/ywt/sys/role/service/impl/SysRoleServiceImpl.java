package com.yiwei.ywt.sys.role.service.impl;


import com.yiwei.ywt.framework.service.BaseService;
import com.yiwei.ywt.sys.role.mapper.SysRoleMapper;
import com.yiwei.ywt.sys.role.model.SysRole;
import com.yiwei.ywt.sys.role.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 系统角色service实现类</p>
 *
 * @author czy
 * @version 1.0.0
 * @date 2019/04/11 8:36
 */
@Service
public class SysRoleServiceImpl extends BaseService<SysRole> implements SysRoleService {


    @Autowired
    private SysRoleMapper sysRoleMapper;


    /**
     * 添加角色信息
     * @param sysRole       角色对象信息
     * @return  sysRole
     */
    public SysRole addEntity(SysRole sysRole) {
        return 0 < this.sysRoleMapper.insert(sysRole) ? sysRole : null;
    }

    /**
     * 修改角色信息
     * @param sysRole       角色信息对象
     * @return
     */
    public boolean editEntity(SysRole sysRole) {
        return 0 < this.sysRoleMapper.update(sysRole);
    }

    /**
     * 删除角色信息
     * @param id            角色主键ID
     * @return
     */
    public boolean deleteEntity(Long id) {
        return 0 < this.sysRoleMapper.delete(id);
    }


    /**
     * 启用角色信息
     * @param id  角色主键ID
     * @return
     */
    public boolean enableEntity(Long id) {
        return 0 < this.sysRoleMapper.enableEntity(id);
    }


    /**
     * 禁用角色信息
     * @param id  角色主键ID
     * @return
     */
    public boolean disableEntity(Long id) {
        return 0 < this.sysRoleMapper.disableEntity(id);
    }

}
