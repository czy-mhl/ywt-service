package com.yiwei.ywt.sys.log.model;


import com.yiwei.ywt.framework.model.BaseEntity;
import com.yiwei.ywt.sys.user.model.SysUser;

import java.io.Serializable;
import java.util.Date;

/**
 * Created :czy
 * date:2019/4/15/14:10
 * annotation:SysLogService 实体类
 * table:   T_SYS_LOG
 */
public class SysLog extends BaseEntity implements Serializable {
    /**
     *访问地址
     *  */
    private String requestUri;
    /**
     *访问IP
     * */
    private String requestIp;
    /**
     *访问用户ID
     * */
    private Long   sysUserId;
    /**
     *访问用户帐号
     * */
    private String sysUserAccount;
    /**
     *操作类型(操作类型1=新增，2=修改，3=查询，4=删除，5=审核，6=发布 , 7=撤销 ,8=处理,9=其他)
     * */
    private String operateType;
    private String operationDesc; //操作类型描述
    private String menuName; //菜单名称
    /**
     * 访问模块中文名称
     * */
    private String moduleName;
    /**
     * 访问模块英文名称
     **/
    private String moduleCode;
    /**
     * 访问模块方法中文名称
     * **/
    private String methodName;
    /**
     * 访问模块方法英文名称
     * **/
    private String methodCode;
    /**
     * 访问模块具体操作内容
     **/
    private String moduleContent;
    /**
     * 操作结果（ 1=成功。2=失败【异常】）
     * **/
    private Integer operateResult;
    /**
     * 异常信息
     * */
    private String logContent;
    /**
     *操作时间
     * */
    private Date operateTime;
    /**
     *查询起始时间
     */
    private Date operateTimeBefore;
    /**
     *查询截止时间
     */
    private Date operateTimeAfter;
    /**
     *删除标记
     * */
    private Integer delFlag;
    /**
     * sysuser表
     */
    private SysUser sysUser;

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public String getModuleContent() { return moduleContent; }

    public void setModuleContent(String moduleContent) { this.moduleContent = moduleContent; }

    public String getOperationDesc() { return operationDesc; }

    public void setOperationDesc(String operationDesc) { this.operationDesc = operationDesc; }

    public String getMenuName() { return menuName; }

    public void setMenuName(String menuName) { this.menuName = menuName; }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp;
    }

    public Long getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
    }

    public String getSysUserAccount() {
        return sysUserAccount;
    }

    public void setSysUserAccount(String sysUserAccount) {
        this.sysUserAccount = sysUserAccount;
    }

    public String getOperateType() { return operateType; }

    public void setOperateType(String operateType) { this.operateType = operateType; }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodCode() {
        return methodCode;
    }

    public void setMethodCode(String methodCode) {
        this.methodCode = methodCode;
    }

    public Integer getOperateResult() {
        return operateResult;
    }

    public void setOperateResult(Integer operateResult) {
        this.operateResult = operateResult;
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public Date getOperateTimeBefore() {
        return operateTimeBefore;
    }

    public void setOperateTimeBefore(Date operateTimeBefore) {
        this.operateTimeBefore = operateTimeBefore;
    }

    public Date getOperateTimeAfter() {
        return operateTimeAfter;
    }

    public void setOperateTimeAfter(Date operateTimeAfter) {
        this.operateTimeAfter = operateTimeAfter;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}
