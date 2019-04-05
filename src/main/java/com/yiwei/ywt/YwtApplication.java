package com.yiwei.ywt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Slf4j
@SpringBootApplication
public class YwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(YwtApplication.class, args);
        log.info("后管启动成功");
    }

}
