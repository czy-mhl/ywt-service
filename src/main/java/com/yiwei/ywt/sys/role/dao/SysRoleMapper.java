package com.yiwei.ywt.sys.role.dao;


import com.yiwei.ywt.framework.dao.CRUDMapper;
import com.yiwei.ywt.sys.role.model.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * </p>
 *
 * @author liwenjun
 * @version 1.0.0
 * @date 2016/11/25 8:37
 */
@Mapper
public interface SysRoleMapper extends CRUDMapper<SysRole> {

    SysRole getEntityByRoleCode(@Param(value = "roleCode") String roleCode);

    List<SysRole> selectListBySystemId(@Param(value = "systemId") Long systemId);

    List<SysRole> listAll();

    //  启用角色信息
    int enableEntity(@Param("id") Long id);
    //  禁用角色信息
    int disableEntity(@Param("id") Long id);



}
