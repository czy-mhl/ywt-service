package com.yiwei.ywt.waterCost.prestore.controller;

import com.yiwei.ywt.framework.web.AjaxResponse;
import com.yiwei.ywt.waterCost.prestore.model.BalanceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 水费预存 控制器
 * @author: czy
 * @date: 2019-04-21 11:52
 * @version: 1.0.0
 */
@RestController
@RequestMapping(value = "/prestore")
@Slf4j
public class PrestoreController {
    public AjaxResponse selectBalanceNew(BalanceInfo balanceInfo){
        // todo
        return null;
    }
}
