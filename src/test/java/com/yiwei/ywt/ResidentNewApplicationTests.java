package com.yiwei.ywt;

import com.yiwei.ywt.businessProcess.residentWaterNew.mapper.ResidentWaterMapper;
import com.yiwei.ywt.businessProcess.residentWaterNew.model.ResidentWater;
import com.yiwei.ywt.businessProcess.residentWaterNew.service.ResidentWaterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResidentNewApplicationTests {
    @Resource
    private ResidentWaterMapper waterApplyMapper;

    @Resource
    private ResidentWaterService waterApplyService;

    /**
     * 居民用水新装申请
     */
    @Test
    public void insert() {
        ResidentWater waterApply = new ResidentWater();
        waterApply.setCustomerType("居民客户");
        waterApply.setBusinessType("居民用水新装");
        waterApply.setOwnerName("张三");
        waterApply.setArea("武昌区");
        waterApply.setWaterAddress("易维科技");
        waterApply.setOwnerMobile("18972642658");
        waterApply.setIdType("身份证");
        waterApply.setIdCard("420984199603111012");
        waterApply.setWaterType("居民生活用水");
        waterApply.setManagerName("蔡芝勇");
        waterApply.setManagerMobile("18888888888");

        ResidentWater newWaterApply = waterApplyService.addEntity(waterApply);

        System.out.println(newWaterApply);
    }
}
