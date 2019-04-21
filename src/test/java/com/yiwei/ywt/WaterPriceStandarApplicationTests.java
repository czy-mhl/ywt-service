package com.yiwei.ywt;

import com.yiwei.ywt.sys.serviceInformation.mapper.WaterPriceStandarMapper;
import com.yiwei.ywt.sys.serviceInformation.model.WaterPriceStandar;
import com.yiwei.ywt.sys.serviceInformation.service.WaterPriceStandarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest
public class WaterPriceStandarApplicationTests {

    /**
     * 水价标准测试
     */
    @Resource
    private WaterPriceStandarMapper waterPriceStandarMapper;

    @Autowired
    private WaterPriceStandarService waterPriceStandarService;

    /**
     * 水价标准查询
     */
    @Test
    public void select() {
        WaterPriceStandar waterPriceStandar = waterPriceStandarService.selectByTitle("测试Title");
//        WaterPriceStandar waterPriceStandar = waterPriceStandarMapper.selectByTitle("测试Title");
        System.out.println(waterPriceStandar);
    }
    /**
     * 水价标准插入
     */
    @Test
    public void insert() {
        WaterPriceStandar waterPriceStandar = new WaterPriceStandar();
        waterPriceStandar.setTitle("测试Title");
        waterPriceStandar.setContent("测试Content2");
        waterPriceStandar.setPicture("http://img5.imgtn.bdimg.com/it/u=1638695478,3359394321&fm=26&gp=0.jpg");
//        waterPriceStandarMapper.insert(waterPriceStandar);
        waterPriceStandarService.addEntity(waterPriceStandar);
    }
    /**
     * 水价标准修改
     */
    @Test
    public void update() {
        WaterPriceStandar waterPriceStandar = waterPriceStandarMapper.selectByTitle("测试Title");
        waterPriceStandar.setTitle("测试Title3(update)");
        waterPriceStandarService.editEntity(waterPriceStandar);
    }
    /**
     * 水价标准删除
     */
    @Test
    public void delete() {
        WaterPriceStandar waterPriceStandar = waterPriceStandarMapper.selectByTitle("测试Title2");
        waterPriceStandarMapper.delete(waterPriceStandar.getId());
    }
}
