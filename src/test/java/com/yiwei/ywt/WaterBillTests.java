package com.yiwei.ywt;


import com.yiwei.ywt.waterCost.bill.contorller.WaterBillController;
import com.yiwei.ywt.waterCost.bill.model.WaterBill;
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
        WaterBill waterBill = new WaterBill();
        waterBill.setFamilyCode("1800908647");
        waterBill.setBillMonth(201904);
        this.waterBillController.waterBillList(waterBill);
    }

}
