package com.yiwei.ywt;

import com.yiwei.ywt.businessProcess.againWaterMeter.model.AgainWaterMeter;
import com.yiwei.ywt.businessProcess.againWaterMeter.service.AgainWaterService;
import com.yiwei.ywt.businessProcess.faultRepair.model.FaultRepair;
import com.yiwei.ywt.businessProcess.faultRepair.service.FaultRepairService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FaultRepairApplicationTests {

    @Resource
    private FaultRepairService faultRepairService;

    /**
     * 故障报修
     */
    @Test
    public void insert() {
        FaultRepair faultRepair = new FaultRepair();
        faultRepair.setFamilyNumber("户号");
        faultRepair.setContactsName("联系人");
        faultRepair.setContactsMobile("联系电话");
        faultRepair.setRepairAddress("报修地址");
        faultRepair.setDescription("情况描述");


        System.out.println(faultRepairService.addEntity(faultRepair));
    }
}
