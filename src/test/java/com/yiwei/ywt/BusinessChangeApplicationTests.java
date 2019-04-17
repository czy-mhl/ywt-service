package com.yiwei.ywt;

import com.yiwei.ywt.businessProcess.businessChange.mapper.BusinessChangeMapper;
import com.yiwei.ywt.businessProcess.businessChange.model.BusinessChange;
import com.yiwei.ywt.businessProcess.businessChange.service.BusinessChangeService;
import com.yiwei.ywt.businessProcess.businessCirclesNew.mapper.BusinessWaterMapper;
import com.yiwei.ywt.businessProcess.residentChange.mapper.ResidentChangeMapper;
import com.yiwei.ywt.businessProcess.residentChange.model.ResidentChange;
import com.yiwei.ywt.businessProcess.residentChange.service.ResidentChangeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessChangeApplicationTests {
    @Resource
    private BusinessChangeMapper businessChangeMapper;

    @Resource
    private BusinessChangeService businessChangeService;

    /**
     * 工商用水改移装
     */
    @Test
    public void insert() {
        BusinessChange businessChange = new BusinessChange();
        businessChange.setFamilyNumber("户号");
        businessChange.setFamilyName("户名");
        businessChange.setWaterAddress("用水地址");
        businessChange.setChangeReason("改移原因");
        businessChange.setIdType("证件类型");
        businessChange.setIdCard("420989");
        businessChange.setManagerName("经办人姓名");
        businessChange.setManagerMobile("18972642658");

        BusinessChange businessChange1 = businessChangeService.addEntity(businessChange);
        System.out.println(businessChange1);

    }
}
