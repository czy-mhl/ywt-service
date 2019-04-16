package com.yiwei.ywt;

import com.yiwei.ywt.businessProcess.diBaoPreferential.controller.DibaoController;
import com.yiwei.ywt.businessProcess.diBaoPreferential.model.DibaoInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DibaoPreferentialTests {

    @Autowired
    private DibaoController dibaoController;

    @Test
    public void add(){
        DibaoInfo dibaoInfo = new DibaoInfo();
        dibaoInfo.setFamilyName("czy");
        dibaoInfo.setFamilyCode("001");
        dibaoInfo.setUseWaterAddress("5555");
        dibaoInfo.setApplyType(1);
        dibaoInfo.setFamilyMainName("czy");
        dibaoInfo.setTheLinkman("czy");
        dibaoInfo.setMobilePhone("15090972366");
        dibaoInfo.setIdentityNumber("651216831");
        dibaoInfo.setDibaotekunUrl("22");
        dibaoInfo.setIdentityPictureUrl("222");
        dibaoInfo.setTenancyAgreementFileUrl("2222");
        System.out.println( this.dibaoController.addEntity(dibaoInfo).toString());
    }

}
