package com.yiwei.ywt.businessProcess.messageSubscription.controller;

import com.yiwei.ywt.businessProcess.messageSubscription.model.MessageSubscriptionInfo;
import com.yiwei.ywt.businessProcess.messageSubscription.service.MessageSubscriptionService;
import com.yiwei.ywt.framework.web.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 短信订阅控制器</p>
 * @author czy
 * @version 1.0.0
 * @date 2019/04/14 21:19
 */
@RestController
@RequestMapping(value = "/msgSubscription")
@Slf4j
public class MessageSubscriptionController {

    @Autowired
    private MessageSubscriptionService messageSubscriptionService;

    //@LogAop(menuName = "短信订阅",operationDesc = "新增",operationType = "1")
    @RequestMapping(value = "/addEntity", method = RequestMethod.POST)
    public AjaxResponse addEntity(MessageSubscriptionInfo messageSubscriptionInfo){
        try {
            return null == this.messageSubscriptionService.addEntity(messageSubscriptionInfo)? new AjaxResponse(AjaxResponse.FAILURE_ADD_ENTITY,"error") : AjaxResponse.success("ok");
        } catch (Exception e) {
            log.error("add msgSubscription error",e);
            return AjaxResponse.error(e.getMessage(),messageSubscriptionInfo);
        }
    }


}
