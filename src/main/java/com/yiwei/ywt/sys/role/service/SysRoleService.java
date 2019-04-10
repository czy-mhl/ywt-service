package com.yiwei.ywt.sys.role.service;



import com.yiwei.ywt.sys.role.model.SysRole;

import java.util.List;

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
     * 查询单条角色数据
     * @param id            角色主键ID
     * @return
     */
    SysRole getEntityById(Long id);

    /**
     * 验证角色编码是否存在
     * @param roleCode      角色编码
     * @return
     */
    boolean checkRoleCodeIsExist(String roleCode);

    /**
     * 查询角色列表
     * @param systemId          系统信息ID
     * @return
     */
    List<SysRole> selectListBySystemId(Long systemId);

    /**
     * 查询角色列表
     * @return
     */
    List<SysRole> listAll();


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
