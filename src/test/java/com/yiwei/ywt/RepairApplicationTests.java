package com.yiwei.ywt;

import com.yiwei.ywt.sys.repair.model.Repair;
import com.yiwei.ywt.sys.repair.service.RepairService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepairApplicationTests {

    @Resource
    private RepairService repairService;

    /**
     * 非用户报漏报修申请
     */
    @Test
    public void insertCustomer() {
        Repair repair = new Repair();
        //非户主申请测试
        repair.setRepairType(0);
        repair.setReportLeakArea("湖北武汉");
        repair.setTransactorName("向珂");
        repair.setTransactorMobile("18972642658");
        repair.setReportLeakAddress("易位科技");
        repair.setDescription("因为天气不好，水管结冰");
        System.out.println(repairService.addEntity(repair));
    }
    /**
     * 用户报漏报修申请
     */
    @Test
    public void insertHouseholder() {
        Repair repair = new Repair();
        //非户主申请测试
        repair.setRepairType(1);
        repair.setFamilyNumber("444444444444");
        repair.setReportLeakArea("湖北武汉");
        repair.setTransactorName("向珂");
        repair.setTransactorMobile("18972642658");
        repair.setReportLeakAddress("易位科技");
        repair.setDescription("因为天气不好，水管结冰");
        System.out.println(repairService.addEntity(repair));
    }
}
