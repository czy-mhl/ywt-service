package com.yiwei.ywt;

import com.yiwei.ywt.businessProcess.checkWaterMeter.model.CheckWaterMeter;
import com.yiwei.ywt.businessProcess.checkWaterMeter.service.CheckWaterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CheckWaterMeterApplicationTests {

    @Resource
    private CheckWaterService checkWaterService;

    /**
     * 水表验表申请
     */
    @Test
    public void insert() {
        CheckWaterMeter checkWaterMeter = new CheckWaterMeter();
        checkWaterMeter.setFamilyNumber("户号(校验)");
        checkWaterMeter.setCheckWaterMeterReason("验表原因");
        checkWaterMeter.setTransactor("办理人");
        checkWaterMeter.setTransactorMobile("办理人手机");
        checkWaterMeter.setDescription("定制服务（其他说明）");


        System.out.println(checkWaterService.addEntity(checkWaterMeter));
    }
}
