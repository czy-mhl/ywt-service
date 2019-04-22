package com.yiwei.ywt.sys.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @description: 当月账单推送
 * @author: czy
 * @date: 2019-04-22 14:54
 * @version: 1.0.0
 */
@Slf4j
@Component
public class ThisBillPush {

    @Scheduled(cron = "0 0 10 1 * ?")
    public void billPush(){
        System.out.println("当月账单推送");

    }


}
