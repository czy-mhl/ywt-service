package com.yiwei.ywt;

import com.yiwei.ywt.businessProcess.cancelWaterMeter.model.CancelWaterMeter;
import com.yiwei.ywt.businessProcess.cancelWaterMeter.service.CancelWaterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CancelWaterMeterApplicationTests {

    @Resource
    private CancelWaterService canceWaterService;

    /**
     * 销户申请
     */
    @Test
    public void insert() {
        CancelWaterMeter cancelWaterMeter = new CancelWaterMeter();
        cancelWaterMeter.setFamilyNumber("户号");
        cancelWaterMeter.setOwnerMobile("户主手机号");
        cancelWaterMeter.setTransactor("办理人");
        cancelWaterMeter.setTransactorIdCard("420984");
        cancelWaterMeter.setTransactorMobile("办理人手机");
        cancelWaterMeter.setDescription("定制服务（其他说明）");


        System.out.println(canceWaterService.addEntity(cancelWaterMeter));
    }
}
