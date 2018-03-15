package com.cm.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AlertJob {

    @Scheduled(cron = "0/3 * * * * ?")
    public void run(){
        System.out.println("abc.....");
        System.out.println("bcd.......");
        System.out.println("Zn + MgS04 = ZnS04 + Mg");
    }
}
