package com.yiwei.ywt;

import com.yiwei.ywt.businessProcess.residentChange.mapper.ChangeMapper;
import com.yiwei.ywt.businessProcess.residentChange.model.Change;
import com.yiwei.ywt.businessProcess.residentChange.service.ChangeService;
import com.yiwei.ywt.businessProcess.residentTransfer.mapper.TransferMapper;
import com.yiwei.ywt.businessProcess.residentTransfer.model.Transfer;
import com.yiwei.ywt.businessProcess.residentTransfer.service.TransferService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResidentChangeApplicationTests {
    @Resource
    private ChangeMapper changeMapper;

    @Resource
    private ChangeService changeService;

    /**
     * 居民用水改移装
     */
    @Test
    public void insert() {
        Change change = new Change();
        change.setFamilyNumber("户号");
        change.setFamilyName("户名");
        change.setAddress("用水地址");
        change.setChangeReason("改移原因");
        change.setIdType("证件类型");
        change.setIdCard("420984");
        change.setManagerName("经办人姓名");
        change.setManagerMobile("18972642658");

        Change change1 = changeService.addEntity(change);
        System.out.println(change1);

    }
}
