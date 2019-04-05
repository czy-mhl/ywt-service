package com.yiwei.ywt.user.dao;


import com.yiwei.ywt.user.model.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUserMapper {
    List<SysUser> selectList(@Param("pageIndex") Integer pageIndex, @Param("pageNumber") Integer pageNumber);
    int insert(SysUser record);
}