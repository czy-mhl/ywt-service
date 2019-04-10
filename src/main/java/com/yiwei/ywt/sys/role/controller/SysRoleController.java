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

import java.util.List;

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
     * 查询单条角色数据
     * @param id            角色主键ID
     * @return  AjaxResponse
     */
    @LogAop(menuName = "角色管理",operationDesc = "查询",operationType = "3")
    @RequestMapping(value = "/getEntityById", method = RequestMethod.GET)
    public AjaxResponse getEntityById(@RequestParam(value = "id") Long id){
        try {
            SysRole sysRole = this.sysRoleService.getEntityById(id);
            return AjaxResponse.success("ok", sysRole);
        } catch (Exception e) {
            LOGGER.error("get SysRole error!", e);
            return AjaxResponse.error("error", id);
        }
    }

    /**
     * 验证角色编码是否存在
     * @param roleCode      角色编码
     * @return
     */
    @RequestMapping(value = "/checkRoleCodeIsExist", method = RequestMethod.POST)
    public boolean checkRoleCodeIsExist(@RequestParam(value = "roleCode") String roleCode) {
        return this.sysRoleService.checkRoleCodeIsExist(roleCode);
    }

    /**
     * 查询角色列表
     * @param systemId          系统信息ID
     * @return AjaxResponse
     */
    @RequestMapping(value = "/getListBySystemId", method = RequestMethod.GET)
    public AjaxResponse selectListBySystemId(@RequestParam(value = "systemId") Long systemId){
        try {
            List<SysRole> sysRoleList = this.sysRoleService.selectListBySystemId(systemId);
            return AjaxResponse.success("ok", sysRoleList);
        } catch (Exception e) {
            LOGGER.error("select SysRole List error!", e);
            return AjaxResponse.error("error", systemId);
        }
    }

    /**
     * 查询角色列表
     * @return AjaxResponse
     */
    @LogAop(menuName = "角色管理",operationDesc = "查询",operationType = "3")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public AjaxResponse listAll(){
        try {
            List<SysRole> sysRoleList = this.sysRoleService.listAll();
            return AjaxResponse.success("ok", sysRoleList);
        } catch (Exception e) {
            LOGGER.error("select SysRole listAll error!", e);
            return AjaxResponse.error("error");
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
