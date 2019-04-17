package com.yiwei.ywt;

import com.yiwei.ywt.businessProcess.residentTransfer.mapper.ResidentTransferMapper;
import com.yiwei.ywt.businessProcess.residentTransfer.model.ResidentTransfer;
import com.yiwei.ywt.businessProcess.residentTransfer.service.ResidentTransferService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResidentTransferApplicationTests {
    @Resource
    private ResidentTransferMapper transferMapper;

    @Resource
    private ResidentTransferService transferService;

    /**
     * 居民用水过户申请
     */
    @Test
    public void insert() {
        ResidentTransfer transfer = new ResidentTransfer();
        transfer.setFamilyNumber("户号");
        transfer.setNewFamilyName("新户名");
        transfer.setPropertyAddress("武大航域A1栋12楼");
        transfer.setNewOwnerMobile("新联系电话");
        transfer.setIdType("证件类型");
        transfer.setIdCard("420982");
        transfer.setOwnerCertificateno("产权证号");
        transfer.setOther("其它说明");
        transfer.setWaterAddress("武汉");

        ResidentTransfer transfer1 = transferService.addEntity(transfer);

        System.out.println(transfer1);
    }
}
