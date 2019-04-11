package com.yiwei.ywt.sys.user.service.impl;

import com.yiwei.ywt.framework.service.BaseService;
import com.yiwei.ywt.sys.user.dao.SysUserMapper;
import com.yiwei.ywt.sys.user.model.SysUser;
import com.yiwei.ywt.sys.user.service.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * 系统角色service实现类</p>
 */
@Service
public class SysUserServiceImpl extends BaseService<SysUser> implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    /**
     * 添加用户信息
     */
    @Transactional(rollbackFor = Exception.class)
    public SysUser addEntity(SysUser sysUser) {
        return 0 < this.sysUserMapper.addUser(sysUser) ? sysUser : null;
    }



}
