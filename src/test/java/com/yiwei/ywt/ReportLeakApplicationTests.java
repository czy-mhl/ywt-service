package com.yiwei.ywt;

import com.yiwei.ywt.sys.customerService.model.ReportLeak;
import com.yiwei.ywt.sys.customerService.service.ReportLeakService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportLeakApplicationTests {

    @Resource
    private ReportLeakService reportLeaService;

    /**
     * 报漏报修申请
     */
    @Test
    public void insert() {
        ReportLeak reportLeak = new ReportLeak();
        reportLeak.setReportLeakArea("湖北武汉");
        reportLeak.setTransactorName("向珂");
        reportLeak.setTransactorMobile("18972642658");
        reportLeak.setReportLeakAddress("易位科技");

        System.out.println(reportLeaService.addEntity(reportLeak));
    }
}
