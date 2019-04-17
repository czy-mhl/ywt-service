package com.yiwei.ywt;

import com.yiwei.ywt.businessProcess.FileErrorDeclaration.controller.FileErrorController;
import com.yiwei.ywt.businessProcess.FileErrorDeclaration.model.FileErrorInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileErrorApplyTests {

    @Autowired
    private FileErrorController fileErrorController;

    @Test
    public void add(){
        FileErrorInfo fileErrorInfo = new FileErrorInfo();
        fileErrorInfo.setFamilyCode("002");
        fileErrorInfo.setUseWaterAddress("5555");
        fileErrorInfo.setTheLinkman("czy");
        fileErrorInfo.setMobilePhone("15090972366");
        fileErrorInfo.setErrorDescriptionAccessoryUrl("55555555");
        fileErrorInfo.setPapersAccessoryUrl("55555555");
        fileErrorInfo.setOtherAccessoryUrl("00000000");
        fileErrorInfo.setCheckCode("123456");
        System.out.println( this.fileErrorController.addEntity(fileErrorInfo).toString());
    }

}
