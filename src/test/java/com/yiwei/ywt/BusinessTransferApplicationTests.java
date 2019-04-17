package com.yiwei.ywt;

import com.yiwei.ywt.businessProcess.businessTransfer.mapper.BusinessTransferMapper;
import com.yiwei.ywt.businessProcess.businessTransfer.model.BusinessTransfer;
import com.yiwei.ywt.businessProcess.businessTransfer.service.BusinessTransferService;
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
public class BusinessTransferApplicationTests {
    @Resource
    private BusinessTransferMapper businessTransferMapper;

    @Resource
    private BusinessTransferService businessTransferService;

    /**
     * 工商客户过户申请
     */
    @Test
    public void insert() {
        BusinessTransfer businessTransfer = new BusinessTransfer();
        businessTransfer.setFamilyNumber("户号");
        businessTransfer.setWaterAddress("用水地址");
        businessTransfer.setNewFamilyName("新户名");
        businessTransfer.setPropertyAddress("产权地址");
        businessTransfer.setNewOwnerMobile("新联系电话");
        businessTransfer.setCompanyType("公司证件类型");
        businessTransfer.setCompanyCard("420984");
        businessTransfer.setOwnerCertificateno("产权证号");
        businessTransfer.setOther("其它说明");
        businessTransfer.setWaterAddress("武汉");

        BusinessTransfer businessTransfer1 = businessTransferService.addEntity(businessTransfer);

        System.out.println(businessTransfer1);
    }
}
