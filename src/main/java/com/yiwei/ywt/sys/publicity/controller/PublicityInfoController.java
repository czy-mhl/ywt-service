package com.yiwei.ywt.sys.publicity.controller;

import com.yiwei.ywt.framework.web.AjaxResponse;
import com.yiwei.ywt.sys.publicity.model.PublicityInfo;
import com.yiwei.ywt.sys.publicity.service.PublicityInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: czy
 * @date: 2019-04-22 18:06
 * @version: 1.0.0
 */
@RestController
@RequestMapping(value = "/publicity")
@Slf4j
public class PublicityInfoController {
    @Autowired
    private PublicityInfoService publicityInfoService;

    /**
     * add
     * @param publicityInfo
     * @return
     */
    @RequestMapping(value = "/addEntity")
    public AjaxResponse addEntity(PublicityInfo publicityInfo){
        try {
            return null==this.publicityInfoService.addEntity(publicityInfo)?new AjaxResponse(AjaxResponse.FAILURE_ADD_ENTITY,"error"):AjaxResponse.success("ok");
        } catch (Exception e) {
            log.error("add publicityInfo error",e);
            return AjaxResponse.error("error");
        }
    }

    /**
     * selectEntityByType
     * @param type
     * @return
     */
    @RequestMapping(value = "/selectEntityByType")
    public AjaxResponse selectEntityByType(String type){
        try {
            List<PublicityInfo> publicityInfoList = this.publicityInfoService.selectEntityByType(type);
            return publicityInfoList.isEmpty() ? new AjaxResponse(AjaxResponse.FAILURE_SELECT_ENTITY,"查询数据为空",type):AjaxResponse.success("ok",publicityInfoList);
        } catch (Exception e) {
            log.error("selectEntityByType error",e);
            return AjaxResponse.error("error",type);
        }
    }

    /**
     * del
     * @param id
     * @return
     */
    @RequestMapping(value = "/delEntity")
    public AjaxResponse delEntity(String id){
        try {
            return this.publicityInfoService.delEntity(Long.parseLong(id))?AjaxResponse.success("ok"):new AjaxResponse(AjaxResponse.FAILURE_DEL_ENTITY,"error",id);
        } catch (Exception e) {
            log.error("delEntity",e);
            return AjaxResponse.error("error",id);
        }

    }

    /**
     * up
     * @param publicityInfo
     * @return
     */
    @RequestMapping(value = "/updateEntity")
    public AjaxResponse updateEntity(PublicityInfo publicityInfo){
        try {
            return null == this.publicityInfoService.updateEntity(publicityInfo)?new AjaxResponse(AjaxResponse.FAILURE_EDIT_ENTITY,"error",publicityInfo):AjaxResponse.success("ok");
        } catch (Exception e) {
            log.error("updateEntity",e);
            return AjaxResponse.error("error",publicityInfo);
        }
    }
}
