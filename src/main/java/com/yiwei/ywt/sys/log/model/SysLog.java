package com.yiwei.ywt.sys.log.model;


import com.yiwei.ywt.framework.model.BaseEntity;
import com.yiwei.ywt.sys.user.model.SysUser;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created :czy
 * date:2019/4/15/14:10
 * annotation:SysLogService 实体类
 * table:   T_SYS_LOG
 */
@Data
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
    /**
     * 操作类型描述
     */
    private String operationDesc;
    /**
     * 菜单名称
     */
    private String menuName;
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


}
