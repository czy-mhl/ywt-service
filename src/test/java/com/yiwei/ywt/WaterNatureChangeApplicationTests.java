package com.yiwei.ywt;

import com.yiwei.ywt.businessProcess.waterNatureChange.model.WaterNatureChange;
import com.yiwei.ywt.businessProcess.waterNatureChange.service.WaterNatureChangeService;
import com.yiwei.ywt.businessProcess.waterPeopleChange.model.WaterPeopleChange;
import com.yiwei.ywt.businessProcess.waterPeopleChange.service.WaterPeopleChangeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WaterNatureChangeApplicationTests {

    @Resource
    private WaterNatureChangeService waterNatureChangeService;

    /**
     * 用水性质变更
     */
    @Test
    public void insert() {
        WaterNatureChange waterNatureChange = new WaterNatureChange();
        waterNatureChange.setFamilyNumber("户号（校验）");
        waterNatureChange.setTransactor("办理人");
        waterNatureChange.setTransactorMobile("办理人手机");


        System.out.println(waterNatureChangeService.addEntity(waterNatureChange));
    }
}
