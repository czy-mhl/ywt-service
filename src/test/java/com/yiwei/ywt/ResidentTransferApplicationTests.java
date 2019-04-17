package com.yiwei.ywt;

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
public class ResidentTransferApplicationTests {
    @Resource
    private TransferMapper transferMapper;

    @Resource
    private TransferService transferService;

    /**
     * 居民用水过户申请
     */
    @Test
    public void insert() {
        Transfer transfer = new Transfer();
        transfer.setOldFamilyNumber("旧户号");
        transfer.setNewFamilyNumber("新户号");
        transfer.setNewFamilyName("新户名");
        transfer.setPropertyAddress("武大航域A1栋12楼");
        transfer.setNewOwnerMobile("新联系电话");
        transfer.setIdType("证件类型");
        transfer.setIdCard("420985");
        transfer.setOwnerCertificateno("产权证号");
        transfer.setOther("其它说明");

        Transfer transfer1 = transferService.addEntity(transfer);

        System.out.println(transfer1);
    }
}
