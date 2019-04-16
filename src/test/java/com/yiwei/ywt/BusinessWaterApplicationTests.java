package com.yiwei.ywt;

import com.yiwei.ywt.businessProcess.businessCirclesNew.mapper.BusinessWaterMapper;
import com.yiwei.ywt.businessProcess.businessCirclesNew.model.BusinessWater;
import com.yiwei.ywt.businessProcess.businessCirclesNew.service.BusinessWaterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessWaterApplicationTests {
    @Resource
    private BusinessWaterMapper businessWaterMapper;

    @Resource
    private BusinessWaterService businessWaterService;

    /**
     * 工商用水新装申请
     */
    @Test
    public void insert() {
        BusinessWater businessWater = new BusinessWater();
        businessWater.setCustomerType("工商客户");
        businessWater.setBusinessType("工商用水新装");
        businessWater.setOwnerName("向珂");
        businessWater.setArea("洪山区");
        businessWater.setAddress("易维科技");
        businessWater.setOwnerMobile("18972642658");
        businessWater.setCompanyType("身份证");
        businessWater.setCreditCode("统一社会信用代码");
        businessWater.setWaterType("居民生活用水");
        businessWater.setManagerName("蔡芝勇");
        businessWater.setManagerMobile("18888888888");

        BusinessWater newBusinessWater = businessWaterService.addEntity(businessWater);
        System.out.println(newBusinessWater);
    }
}
