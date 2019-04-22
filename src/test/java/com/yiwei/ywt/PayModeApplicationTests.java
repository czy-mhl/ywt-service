package com.yiwei.ywt;

import com.yiwei.ywt.sys.serviceInformation.mapper.PayModeMapper;
import com.yiwei.ywt.sys.serviceInformation.mapper.WaterPriceStandarMapper;
import com.yiwei.ywt.sys.serviceInformation.model.PayMode;
import com.yiwei.ywt.sys.serviceInformation.model.WaterPriceStandar;
import com.yiwei.ywt.sys.serviceInformation.service.PayModeService;
import com.yiwei.ywt.sys.serviceInformation.service.WaterPriceStandarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PayModeApplicationTests {

    /**
     * 交费方式测试
     */
    @Resource
    private PayModeMapper payModeMapper;

    @Resource
    private PayModeService payModeService;
    /**
     * 交费方式查询
     */
    @Test
    public void select() {
        List<PayMode> payModes = payModeService.selectByTitle("营业网点");
        for (PayMode payMode : payModes) {
            System.out.println(payMode);
        }
    }
    /**
     * 交费方式插入
     */
    @Test
    public void insert() {
        List<PayMode> payModes = payModeService.selectByTitle("营业网点");
        int num = payModes.size();
//        PayMode payMode = new PayMode();
//        payMode.setTitle("营业网点");
//        payMode.setContent("昆明清源自来水有限责任公司现有" + (num+1) + "个客服营业厅为客户办理缴费和自来水相关业务" );
//        payMode.setBusinessHallName("雨花营业厅");
//        payMode.setBusinessHallAddress("呈贡新城名族大学对面");
//        payMode.setBusinessHallTelephone("67442279");
//        payMode.setPicture("http://img5.imgtn.bdimg.com/it/u=1638695478,3359394321&fm=26&gp=0.jpg");

        PayMode payMode = new PayMode();
        payMode.setTitle("营业网点");
        payMode.setContent("昆明清源自来水有限责任公司现有" + (num+1) + "个客服营业厅为客户办理缴费和自来水相关业务" );
        payMode.setBusinessHallName("呈贡营业厅");
        payMode.setBusinessHallAddress("呈贡老城兴呈路4951号");
        payMode.setBusinessHallTelephone("67477718");
        payMode.setPicture("http://img5.imgtn.bdimg.com/it/u=1638695478,3359394321&fm=26&gp=0.jpg");

        payModeService.addEntity(payMode);
    }
    /**
     * 交费方式修改
     */
    @Test
    public void update() {
        PayMode payMode = new PayMode();
        payMode.setId(1L);
        payMode.setBusinessHallTelephone("88888");

        payModeService.editEntity(payMode);
    }
    /**
     * 交费方式删除
     */
    @Test
    public void delete() {
        payModeService.deleteEntity(4L);
    }
}
