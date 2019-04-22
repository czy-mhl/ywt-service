package com.yiwei.ywt.sys.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @description: 催收账单推送
 * @author: czy
 * @date: 2019-04-22 14:55
 * @version: 1.0.0
 */
@Slf4j
@Component
public class CollectionBillPush {

    @Scheduled(cron = "0 0 10 * * ?")
    public void billPush(){
        System.out.println("催收账单推送");
        // todo


    }
}
