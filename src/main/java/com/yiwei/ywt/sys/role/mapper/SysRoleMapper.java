package com.yiwei.ywt.sys.role.mapper;


import com.yiwei.ywt.framework.dao.CRUDMapper;
import com.yiwei.ywt.sys.role.model.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * </p>
 *
 * @author czy
 * @version 1.0.0
 * @date 2019/4/11 8:37
 */
@Mapper
public interface SysRoleMapper extends CRUDMapper<SysRole> {
    //  启用角色信息
    int enableEntity(@Param("id") Long id);
    //  禁用角色信息
    int disableEntity(@Param("id") Long id);



}
