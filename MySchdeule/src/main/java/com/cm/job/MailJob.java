package com.cm.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MailJob {

    public void run(){
        System.out.println("发邮件啦。。。。");
    }
}
