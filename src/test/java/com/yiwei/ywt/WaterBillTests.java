package com.yiwei.ywt;


import com.yiwei.ywt.waterCost.bill.contorller.WaterBillController;
import com.yiwei.ywt.waterCost.bill.model.WaterBillInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WaterBillTests {

    @Autowired
    private WaterBillController waterBillController;
    @Test
    public void select(){
        WaterBillInfo waterBill = new WaterBillInfo();
        waterBill.setFamilyCode("1800908647");
        //waterBill.setBillMonth(201904);  http://wze2rz.natappfree.cc/yiwei/bill/waterBillList?familyCode=1800908647
        this.waterBillController.waterBillList(waterBill);
    }

}
