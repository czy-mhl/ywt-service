package com.yiwei.ywt.sys.log.service;



import com.yiwei.ywt.framework.pagination.Page;
import com.yiwei.ywt.sys.log.model.SysLog;
import com.yiwei.ywt.sys.user.model.SysUser;

import java.util.Date;

/**
 * Created :czy
 * date:2019/04/15/17:35
 * annotation:SysLog 业务层接口
 * table:
 */
public interface SysLogService {


    /**
     * 分页查询
     * @param sysUserAccount 访问用户帐号
     * @param operateTimeBefore 操作起始时间
     * @param operateTimeAfter 操作结束时间
     * @param pageIndex         页码
     * @param pageSize          每页显示数据条数
     * @return
     */
    Page<SysLog> selectPageList(String sysUserAccount, Date operateTimeBefore, Date operateTimeAfter, Integer pageIndex, Integer pageSize) ;
    Boolean addEntity(String ip, String operateType, SysUser user);

    Long getLogById(Long id);

    boolean createSysLog(String requestUri, String requestIp, SysUser sysUser, String operateType, String operationDesc,
                         String moduleName, String moduleContent, Integer operateResult, String logContent, String menuName);
}
