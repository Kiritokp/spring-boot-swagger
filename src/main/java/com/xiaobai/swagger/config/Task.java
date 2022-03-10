package com.xiaobai.swagger.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author xiaobai
 * @create 2021-08-28 14:50
 */
@Component
public class Task {

    @Scheduled(cron="0/3 * * * * ?")//每10秒执行一次
    public void task(){
        System.out.println(123);
    }

}
