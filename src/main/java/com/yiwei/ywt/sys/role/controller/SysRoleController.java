package com.yiwei.ywt.sys.role.controller;


import com.yiwei.ywt.framework.aop.LogAop;
import com.yiwei.ywt.framework.web.AjaxResponse;
import com.yiwei.ywt.framework.web.BaseController;
import com.yiwei.ywt.sys.role.model.SysRole;
import com.yiwei.ywt.sys.role.service.SysRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 角色管理控制器</p>
 *
 * @author czy
 * @version 1.0.0
 * @date 2019/04/10 21:19
 */
@RestController
@RequestMapping(value = "/sys/role")
public class SysRoleController extends BaseController {


    private static final Logger LOGGER = LoggerFactory.getLogger(SysRoleController.class);

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 添加角色信息
     * @param sysRole           角色对象信息
     * @return AjaxResponse
     */
    @LogAop(menuName = "角色管理",operationDesc = "新增",operationType = "1")
    @RequestMapping(value = "/addEntity", method = RequestMethod.POST)
    public AjaxResponse addEntity(SysRole sysRole) {
        try{
            sysRole = this.sysRoleService.addEntity(sysRole);
            return null == sysRole ? new AjaxResponse(AjaxResponse.FAILURE_ADD_ENTITY, "error", sysRole) : AjaxResponse.success("ok", sysRole);
        }catch (Exception e){
            LOGGER.error("add SysRole error!", e);
            return AjaxResponse.error("error", sysRole);
        }
    }

    /**
     * 修改角色信息
     * @param sysRole           角色对象信息
     * @return AjaxResponse
     */
    @LogAop(menuName = "角色管理",operationDesc = "修改",operationType = "2")
    @RequestMapping(value = "/editEntity", method = RequestMethod.POST)
    public AjaxResponse editEntity(SysRole sysRole) {
        try{
            return this.sysRoleService.editEntity(sysRole) ? AjaxResponse.success("ok", sysRole) : new AjaxResponse(AjaxResponse.FAILURE_EDIT_ENTITY, "error", sysRole);
        }catch (Exception e){
            LOGGER.error("edit SysRole error!", e);
            return AjaxResponse.error("error", sysRole);
        }

    }

    /**
     * 删除角色信息
     * @param id            角色主键ID
     * @return  AjaxResponse
     */
    @LogAop(menuName = "角色管理",operationDesc = "删除",operationType = "4")
    @RequestMapping(value = "/deleteEntity", method = RequestMethod.POST)
    public AjaxResponse deleteEntity(@RequestParam(value = "id") Long id) {
        try {
            return this.sysRoleService.deleteEntity(id) ? AjaxResponse.success("ok", id) : new AjaxResponse(AjaxResponse.FAILURE_DEL_ENTITY, "error", id);
        } catch (Exception e) {
            LOGGER.error("delete SysRole error!", e);
            return AjaxResponse.error("error", id);
        }
    }



    /**
     * 启用角色信息
     * @param id  角色主键ID
     * @return  AjaxResponse
     */
    @LogAop(menuName = "角色管理",operationDesc = "启用",operationType = "10")
    @RequestMapping(value = "/enableEntity", method = RequestMethod.POST)
    public AjaxResponse enableEntity(@RequestParam(value = "id") Long id) {
        try {
            return this.sysRoleService.enableEntity(id) ? AjaxResponse.success("ok", id) : new AjaxResponse(AjaxResponse.FAILURE_DEL_ENTITY, "error", id);
        } catch (Exception e) {
            LOGGER.error("delete SysRole error!", e);
            return AjaxResponse.error("error", id);
        }
    }

    /**
     * 禁用角色信息
     * @param id  角色主键ID
     * @return  AjaxResponse
     */
    @LogAop(menuName = "角色管理",operationDesc = "禁用",operationType = "11")
    @RequestMapping(value = "/disableEntity", method = RequestMethod.POST)
    public AjaxResponse disableEntity(@RequestParam(value = "id") Long id) {
        try {
            return this.sysRoleService.disableEntity(id) ? AjaxResponse.success("ok", id) : new AjaxResponse(AjaxResponse.FAILURE_DEL_ENTITY, "error", id);
        } catch (Exception e) {
            LOGGER.error("delete SysRole error!", e);
            return AjaxResponse.error("error", id);
        }
    }

}
