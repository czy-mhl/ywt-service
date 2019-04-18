package com.yiwei.ywt;

import com.yiwei.ywt.waterCost.myRecord.controller.MyRecordController;
import com.yiwei.ywt.waterCost.myRecord.model.BillingInformation;
import com.yiwei.ywt.waterCost.myRecord.model.MyRecordInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description: 我的档案test
 * @author: czy
 * @date: 2019-04-18 17:03
 * @version: 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyRecordTests {
    @Autowired
    private MyRecordController myRecordController;
    @Test
    public void select(){
        MyRecordInfo myRecordInfo = new MyRecordInfo();
        myRecordInfo.setFamilyCode("1800908647");
        System.out.println(this.myRecordController.selectEntityByFamilyCode(myRecordInfo).toString());

    }
    @Test
    public void update(){
        BillingInformation billingInformation = new BillingInformation();
        billingInformation.setFamilyCode("1800908647");
        billingInformation.setEmail("cai_ziyong@163.com");
        billingInformation.setBillingInformationAccount("888888888");
        this.myRecordController.updateEntityByFamilyCode(billingInformation);
    }
}
