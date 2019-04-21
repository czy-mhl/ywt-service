package com.yiwei.ywt;

import com.yiwei.ywt.businessProcess.waterPeopleChange.model.WaterPeopleChange;
import com.yiwei.ywt.businessProcess.waterPeopleChange.service.WaterPeopleChangeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WaterPeopleChangeApplicationTests {

    @Resource
    private WaterPeopleChangeService waterPeopleChangeService;

    /**
     * 用水人口变更
     */
    @Test
    public void insert() {
        WaterPeopleChange waterPeopleChange = new WaterPeopleChange();
        waterPeopleChange.setFamilyNumber("户号(8)");
        waterPeopleChange.setApplyPeopleNumber(4);
        waterPeopleChange.setTransactorMobile("办理人手机");


        System.out.println(waterPeopleChangeService.addEntity(waterPeopleChange));
    }
}
