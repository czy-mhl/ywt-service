package com.yiwei.ywt.sys.menu.controller;

import com.yiwei.ywt.framework.aop.LogAop;
import com.yiwei.ywt.framework.web.AjaxResponse;
import com.yiwei.ywt.sys.menu.model.SysMenu;
import com.yiwei.ywt.sys.menu.service.SysMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * 菜单管理控制器</p>
 *
 * @author czy
 * @version 1.0.0
 * @date 2019/04/14 21:19
 */
@RestController
@RequestMapping(value = "/menu")
@Slf4j
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;
    /**
     * 添加菜单
     * @param sysMenu           角色对象信息
     * @return AjaxResponse
     */
    //@LogAop(menuName = "菜单管理",operationDesc = "新增",operationType = "1")
    @RequestMapping(value = "/addEntity", method = RequestMethod.POST)
    public AjaxResponse addEntity(SysMenu sysMenu) {
        try{
            sysMenu = this.sysMenuService.addEntity(sysMenu);
            return null == sysMenu ? new AjaxResponse(AjaxResponse.FAILURE_ADD_ENTITY, "error") : AjaxResponse.success("ok");
        }catch (Exception e){
            log.error("add SysMenu error!", e);
            return AjaxResponse.error("error", sysMenu);
        }
    }

    /**
     * 删除菜单
     * @param menuId
     * @return AjaxResponse
     */
    //@LogAop(menuName = "菜单管理",operationDesc = "删除",operationType = "4")
    @RequestMapping(value = "/deleteEntity", method = RequestMethod.POST)
    public AjaxResponse deleteEntity(@RequestParam(value = "menuId") Long menuId) {
        try{
            return this.sysMenuService.deleteEntityMenu(menuId) ? new AjaxResponse(AjaxResponse.FAILURE_DEL_ENTITY, "error") : AjaxResponse.success("ok");
        }catch (Exception e){
            log.error("del SysMenu error!", e);
            return AjaxResponse.error("error",menuId);
        }
    }

    /**
     * 修改菜单
     * @param sysMenu           角色对象信息
     * @return AjaxResponse
     */
    //@LogAop(menuName = "角色管理",operationDesc = "修改",operationType = "2")
    @RequestMapping(value = "/editEntity", method = RequestMethod.POST)
    public AjaxResponse editEntity(SysMenu sysMenu) {
        try{
            return this.sysMenuService.editEntity(sysMenu) ? new AjaxResponse(AjaxResponse.FAILURE_EDIT_ENTITY, "error") : AjaxResponse.success("ok");
        }catch (Exception e){
            log.error("edit SysMenu error!", e);
            return AjaxResponse.error("error", sysMenu);
        }
    }





}
