package com.yiwei.ywt;

import com.yiwei.ywt.businessProcess.againWaterMeter.model.AgainWaterMeter;
import com.yiwei.ywt.businessProcess.againWaterMeter.service.AgainWaterService;
import com.yiwei.ywt.businessProcess.stopWaterMeter.model.StopWaterMeter;
import com.yiwei.ywt.businessProcess.stopWaterMeter.service.StopWaterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgainWaterMeterApplicationTests {

    @Resource
    private AgainWaterService againWaterService;

    /**
     * 复接申请
     */
    @Test
    public void insert() {
        AgainWaterMeter againWaterMeter = new AgainWaterMeter();
        againWaterMeter.setFamilyNumber("户号");
        againWaterMeter.setOwnerMobile("户主手机号码");
        againWaterMeter.setTransactor("办理人");
        againWaterMeter.setTransactorIdCard("420984");
        againWaterMeter.setTransactorMobile("办理人手机");
        againWaterMeter.setDescription("定制服务（其他说明）");


        System.out.println(againWaterService.addEntity(againWaterMeter));
    }
}
