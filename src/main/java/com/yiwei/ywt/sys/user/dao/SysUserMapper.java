package com.yiwei.ywt.sys.user.dao;


import com.yiwei.ywt.sys.user.model.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper {

    Integer addUser(SysUser sysUser);
}