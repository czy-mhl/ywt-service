package com.yiwei.ywt.sys.role.service.impl;


import com.yiwei.ywt.framework.service.BaseService;
import com.yiwei.ywt.sys.role.dao.SysRoleMapper;
import com.yiwei.ywt.sys.role.model.SysRole;
import com.yiwei.ywt.sys.role.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统角色service实现类</p>
 *
 * @author liwenjun
 * @version 1.0.0
 * @date 2016/11/25 8:36
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
     * 查询单条角色数据
     * @param id            角色主键ID
     * @return
     */
    public SysRole getEntityById(Long id) {
        return this.sysRoleMapper.getEntityById(id);
    }

    /**
     * 验证角色编码是否存在
     * @param roleCode      角色编码
     * @return
     */
    public boolean checkRoleCodeIsExist(String roleCode) {
        SysRole sysRole = this.sysRoleMapper.getEntityByRoleCode(roleCode);
        return null == sysRole;
    }

    /**
     * 查询角色列表
     * @param systemId          系统信息ID
     * @return
     */
    public List<SysRole> selectListBySystemId(Long systemId){
        return this.sysRoleMapper.selectListBySystemId(systemId);
    }

    /**
     * 查询角色列表
     * @return
     */
    public List<SysRole> listAll(){
        return this.sysRoleMapper.listAll();
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
