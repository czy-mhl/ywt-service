package com.yiwei.ywt;

import com.yiwei.ywt.sys.publicity.controller.PublicityInfoController;
import com.yiwei.ywt.sys.publicity.model.PublicityInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description:
 * @author: czy
 * @date: 2019-04-22 18:50
 * @version: 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PublicityTests {
    @Autowired
    private PublicityInfoController publicityInfoController;
    @Test
    public void add(){
        PublicityInfo publicityInfo = new PublicityInfo();
        publicityInfo.setType("低保户优惠政策");
        publicityInfo.setTitle("2019-04-22 自来水集团");
        publicityInfo.setInfo("撒旦发射点发射点发射点发射点发射点发生");
        publicityInfo.setSort("1");
        System.out.println(this.publicityInfoController.addEntity(publicityInfo).toString());
    }
    @Test
    public void del(){
        this.publicityInfoController.delEntity("1");

    }
    @Test
    public void up(){
        PublicityInfo publicityInfo = new PublicityInfo();
        publicityInfo.setId(2L);
        publicityInfo.setType("低保户优惠政策");
        publicityInfo.setTitle("2019-04-22 自来水集团");
        publicityInfo.setInfo("8946518135431351335dfasdfasdfasdfasdf");
        publicityInfo.setSort("1");
        System.out.println(this.publicityInfoController.updateEntity(publicityInfo).toString());
    }
    @Test
    public void sel(){
        System.out.println(this.publicityInfoController.selectEntityByType("低保户优惠政策").toString());
    }
}
