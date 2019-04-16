package com.yiwei.ywt;

import com.yiwei.ywt.waterCostBill.bill.dao.TUserBillMapper;
import com.yiwei.ywt.waterCostBill.bill.model.TUserBill;
import com.yiwei.ywt.waterCostBill.bill.service.SysBillService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BillApplicationTests {
    @Resource
    private SysBillService sysBillService;

    @Resource
    private TUserBillMapper tUserBillMapper;

    /**
     * 根据UserId查询出UserBill账单
     */
    @Test
    public void findByUserId() {
        List<TUserBill> userBills = sysBillService.findByUserId(1L);
        for (TUserBill userBill : userBills) {
            System.out.println(userBill);
        }
    }

    /**
     * 根据billMonth当前月份查询出UserBill账单
     */
    @Test
    public void findBybillMonth() {
        TUserBill userBill = sysBillService.findBybillMonth("2019-04");
        System.out.println(userBill);
    }

    /**
     * 根据主键id判断新增或者修改（如主键存在，则转为更新记录）
     */
    @Test
    public void insertUserBill() {
        TUserBill userBill = tUserBillMapper.selectByPrimaryKey(4L);
        //insert算出当月总额存入
        sysBillService.insertByTUserBill(userBill);
    }

}
