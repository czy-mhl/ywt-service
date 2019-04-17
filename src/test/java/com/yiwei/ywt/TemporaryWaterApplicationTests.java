package com.yiwei.ywt;

import com.yiwei.ywt.businessProcess.businessCirclesNew.model.BusinessWater;
import com.yiwei.ywt.businessProcess.temporaryWater.mapper.TemporaryWaterMapper;
import com.yiwei.ywt.businessProcess.temporaryWater.model.TemporaryWater;
import com.yiwei.ywt.businessProcess.temporaryWater.service.TemporaryWaterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TemporaryWaterApplicationTests {
    @Resource
    private TemporaryWaterMapper temporaryWaterMapper;

    @Resource
    private TemporaryWaterService temporaryWaterService;

    /**
     * 临时施工用水新增
     */
    @Test
    public void insert() {
        TemporaryWater temporaryWater = new TemporaryWater();
        temporaryWater.setCustomerType("临时施工用水");
        temporaryWater.setOwnerName("张三");
        temporaryWater.setArea("武昌区");
        temporaryWater.setWaterAddress("易维科技");
        temporaryWater.setOwnerMobile("18972642658");
        temporaryWater.setCompanyType("营业执照");
        temporaryWater.setCreditCode("420984199603111013");
        temporaryWater.setCorporateRepresenName("李四");
        temporaryWater.setCorporateRepresenIdCard("444333222211112111");
        TemporaryWater temporaryWater1 = temporaryWaterService.addEntity(temporaryWater);
        System.out.println(temporaryWater1);
    }
}
