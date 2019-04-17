package com.yiwei.ywt;

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
public class ResidentChangeApplicationTests {
    @Resource
    private ResidentChangeMapper residentChangeMapper;

    @Resource
    private ResidentChangeService residentChangeService;

    /**
     * 居民用水改移装
     */
    @Test
    public void insert() {
        ResidentChange change = new ResidentChange();
        change.setFamilyNumber("户号");
        change.setFamilyName("户名");
        change.setAddress("用水地址");
        change.setChangeReason("改移原因");
        change.setIdType("证件类型");
        change.setIdCard("420983");
        change.setManagerName("经办人姓名");
        change.setManagerMobile("18972642658");
        System.out.println(change.getIdCard());

        ResidentChange residentChange = residentChangeService.addEntity(change);

        System.out.println(residentChange);

    }
}
