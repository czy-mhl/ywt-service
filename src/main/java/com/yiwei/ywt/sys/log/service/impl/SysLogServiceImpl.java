package com.yiwei.ywt.sys.log.service.impl;


import com.yiwei.ywt.framework.pagination.Page;
import com.yiwei.ywt.framework.service.BaseService;
import com.yiwei.ywt.sys.log.mapper.SysLogMapper;
import com.yiwei.ywt.sys.log.model.SysLog;
import com.yiwei.ywt.sys.log.service.SysLogService;
import com.yiwei.ywt.sys.user.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
 * Created :czy
 * date:2019/04/15/17:37
 * annotation:SysLog 业务层实现类
 * table:
 */
@Service
public class SysLogServiceImpl  extends BaseService<SysLog> implements SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    /**
     * 分页查询
     * @param sysUserAccount 访问用户帐号
     * @param operateTimeBefore 操作起始时间
     * @param operateTimeAfter 操作结束时间
     * @param pageIndex         页码
     * @param pageSize          每页显示数据条数
     * @return
     */
    public Page<SysLog> selectPageList(String sysUserAccount, Date operateTimeBefore, Date operateTimeAfter , Integer pageIndex, Integer pageSize) {
        //new 系统日志对象
        SysLog sysLog=new SysLog();
        sysLog.setSysUserAccount(sysUserAccount);
        sysLog.setOperateTimeBefore(operateTimeBefore);
        sysLog.setOperateTimeAfter(operateTimeAfter);

        Page<SysLog> page = createPage(sysLogMapper,sysLog,pageIndex,pageSize);
        return page;
    }
    public Boolean addEntity(String ip,String operateType, SysUser user){
        SysLog log = new SysLog();
        log.setRequestIp(ip);
        log.setSysUserId(user.getId());
        log.setSysUserAccount(user.getMobile());
        log.setOperateResult(1);
        log.setOperateTime(new Date());
        log.setOperateType(operateType);
        Boolean  b = 0 < this.sysLogMapper.insert(log);
        return b;
    }


    public Long getLogById(Long id){
        Long count = this.sysLogMapper.getLogById(id);
        return count;
    }

    public boolean createSysLog(String requestUri, String requestIp, SysUser sysUser, String operateType,String operationDesc,
                                String moduleName, String moduleContent, Integer operateResult, String logContent,String menuName){
        SysLog sysLog = new SysLog();
        sysLog.setRequestUri(requestUri);
        sysLog.setRequestIp(requestIp);
//        sysLog.setSysUserId(sysUser.getId());
//        sysLog.setSysUserAccount(sysUser.getMobile());
        sysLog.setOperateType(operateType);
        sysLog.setModuleName(moduleName);
        sysLog.setModuleContent(moduleContent);
        sysLog.setOperateResult(operateResult);
        sysLog.setLogContent(logContent);
        sysLog.setOperationDesc(operationDesc);
        sysLog.setMenuName(menuName);

        return 0 < sysLogMapper.insert(sysLog);
    }
}
