package com.yiwei.ywt;

import com.yiwei.ywt.businessProcess.stopWaterMeter.model.StopWaterMeter;
import com.yiwei.ywt.businessProcess.stopWaterMeter.service.StopWaterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StopWaterMeterApplicationTests {

    @Resource
    private StopWaterService stopWaterService;

    /**
     * 暂停申请
     */
    @Test
    public void insert() {
        StopWaterMeter stopWaterMeter = new StopWaterMeter();
        stopWaterMeter.setFamilyNumber("户号");
        stopWaterMeter.setOwnerMobile("户主手机号码");
        stopWaterMeter.setTransactor("办理人");
        stopWaterMeter.setTransactorIdCard("420984");
        stopWaterMeter.setTransactorMobile("办理人手机");
        stopWaterMeter.setDescription("定制服务（其他说明）");


        System.out.println(stopWaterService.addEntity(stopWaterMeter));
    }
}
