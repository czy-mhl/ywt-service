package com.yiwei.ywt;

import com.yiwei.ywt.businessProcess.residentNew.mapper.WaterApplyMapper;
import com.yiwei.ywt.businessProcess.residentNew.model.WaterApply;
import com.yiwei.ywt.businessProcess.residentNew.service.WaterApplyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WaterApplyApplicationTests {
    @Resource
    private WaterApplyMapper waterApplyMapper;

    @Resource
    private WaterApplyService waterApplyService;

    /**
     * 居民用水新装申请
     */
    @Test
    public void insert() {
        WaterApply waterApply = new WaterApply();
        waterApply.setCustomerType("居民客户");
        waterApply.setBusinessType("居民用水新装");
        waterApply.setOwnerName("向珂");
        waterApply.setArea("洪山区");
        waterApply.setAddress("易维科技");
        waterApply.setOwnerMobile("18972642658");
        waterApply.setIdType("身份证");
        waterApply.setIdCard("420984199603111013");
        waterApply.setWaterType("居民生活用水");
        waterApply.setManagerName("蔡芝勇");
        waterApply.setManagerMobile("18888888888");

        WaterApply newWaterApply = waterApplyService.addEntity(waterApply);

        System.out.println(newWaterApply);
    }
}
