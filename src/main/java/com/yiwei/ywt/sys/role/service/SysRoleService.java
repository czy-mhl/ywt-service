package com.yiwei.ywt.sys.role.service;



import com.yiwei.ywt.sys.role.model.SysRole;


/**
 * 系统角色service接口类</p>
 *
 * @author czy
 * @version 1.0.0
 * @date 2019/04/10 18:33
 */
public interface SysRoleService {

    /**
     * 添加角色信息
     * @param sysRole       角色对象信息
     * @return  sysRole
     */
    SysRole addEntity(SysRole sysRole);

    /**
     * 修改角色信息
     * @param sysRole       角色信息对象
     * @return
     */
    boolean editEntity(SysRole sysRole);

    /**
     * 删除角色信息
     * @param id            角色主键ID
     * @return
     */
    boolean deleteEntity(Long id);


    /**
     * 启用角色信息
     * @param id  角色主键ID
     * @return
     */
    boolean enableEntity(Long id);

    /**
     * 禁用角色信息
     * @param id  角色主键ID
     * @return
     */
    boolean disableEntity(Long id);
}
