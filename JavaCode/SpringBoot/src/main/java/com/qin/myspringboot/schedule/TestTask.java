package com.qin.myspringboot.schedule;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 */
@Slf4j
@Component
public class TestTask {

    @Scheduled(cron = "0 */1 * * * ?")
    public void test01() {
        log.error("定时器");
        System.out.println("hello world");
    }

}
