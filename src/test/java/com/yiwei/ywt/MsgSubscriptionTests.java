package com.yiwei.ywt;

import com.yiwei.ywt.businessProcess.messageSubscription.controller.MessageSubscriptionController;
import com.yiwei.ywt.businessProcess.messageSubscription.model.MessageSubscriptionInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MsgSubscriptionTests {

    @Autowired
    private MessageSubscriptionController messageSubscriptionController;

    @Test
    public void add(){
        MessageSubscriptionInfo messageSubscriptionInfo = new MessageSubscriptionInfo();
        messageSubscriptionInfo.setFamilyCode("001");
        messageSubscriptionInfo.setMobilePhone("15090972366");
        System.out.println( this.messageSubscriptionController.addEntity(messageSubscriptionInfo).toString());
    }

}
