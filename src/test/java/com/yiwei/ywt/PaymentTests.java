package com.yiwei.ywt;


import com.yiwei.ywt.waterCost.bill.model.WaterBill;
import com.yiwei.ywt.waterCost.payment.controller.PaymentController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentTests {

    @Autowired
    private PaymentController paymentController;
    @Test
    public void select(){
        WaterBill waterBill = new WaterBill();
        waterBill.setFamilyCode("1800908647");
        System.out.println(this.paymentController.selectTodoCostBillList(waterBill));

    }

}
