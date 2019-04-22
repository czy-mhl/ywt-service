package com.yiwei.ywt.sys.serviceInformation.controller;

import com.yiwei.ywt.framework.web.AjaxResponse;
import com.yiwei.ywt.sys.serviceInformation.model.WaterPriceStandar;
import com.yiwei.ywt.sys.serviceInformation.service.WaterPriceStandarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 水价标准
 */
@RestController
@RequestMapping("/waterpricestandar")
@Slf4j
public class WaterPriceStandarController {

    @Resource
    private WaterPriceStandarService waterPriceStandarService;

    /**
     * 水价标准新增
     */
//    @LogAop(menuName = "水价标准",operationDesc = "新增",operationType = "1")
    @RequestMapping(value = "/addEntity", method = RequestMethod.POST)
     public AjaxResponse getWaterPriceStandar(WaterPriceStandar waterPriceStandar) {
        try {
            return null == this.waterPriceStandarService.addEntity(waterPriceStandar)? new AjaxResponse(AjaxResponse.FAILURE_ADD_ENTITY,"error") : AjaxResponse.success("ok");
        } catch (Exception e) {
            log.error("add WaterPriceStandar error",e);
            return AjaxResponse.error(e.getMessage());
        }
    }

    /**
     * 水价标准查询（Title）
     */
//    @LogAop(menuName = "水价标准",operationDesc = "查询",operationType = "3")
    @RequestMapping(value = "/selectEntity", method = RequestMethod.GET)
     public AjaxResponse selectWaterPriceStandar(WaterPriceStandar waterPriceStandar) {
        try {
            WaterPriceStandar priceStandar = waterPriceStandarService.selectByTitle(waterPriceStandar.getTitle());
            return null == priceStandar ? new AjaxResponse(AjaxResponse.FAILURE_SELECT_ENTITY, "error") : AjaxResponse.success("ok",priceStandar);
        } catch (RuntimeException e) {
            log.error("select WaterPriceStandar error",e);
            return AjaxResponse.error("error");
        }
    }

    /**
     * 水价标准修改
     */
//    @LogAop(menuName = "水价标准",operationDesc = "修改",operationType = "2")
    @RequestMapping(value = "/updateEntity", method = RequestMethod.POST)
    public AjaxResponse updateWaterPriceStandar(WaterPriceStandar waterPriceStandar) {
        try {
            return !this.waterPriceStandarService.editEntity(waterPriceStandar)? new AjaxResponse(AjaxResponse.FAILURE_EDIT_ENTITY,"error") : AjaxResponse.success("ok");
        } catch (RuntimeException e) {
            log.error("update WaterPriceStandar error",e);
            return AjaxResponse.error("error");
        }
    }

    /**
     * 水价标准删除
     */
//    @LogAop(menuName = "水价标准",operationDesc = "删除",operationType = "4")
    @RequestMapping(value = "/deleteEntity", method = RequestMethod.POST)
    public AjaxResponse deleteWaterPriceStandar(@RequestParam("ID") Long id) {
        try {
            return !this.waterPriceStandarService.deleteEntity(id)? new AjaxResponse(AjaxResponse.FAILURE_DEL_ENTITY,"error") : AjaxResponse.success("ok");
        } catch (RuntimeException e) {
            log.error("delete WaterPriceStandar error",e);
            return AjaxResponse.error("error");
        }
    }
}
