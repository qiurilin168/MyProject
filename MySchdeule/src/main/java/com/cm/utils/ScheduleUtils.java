package com.cm.utils;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.ParseException;

public class ScheduleUtils {

    public static void change(String jobName,String jobGroup,String triggerName,String triggerGroup,String cronExpress){
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            JobDetail jobDetail = scheduler.getJobDetail(new JobKey(jobName,jobGroup));
            TriggerKey triggerKey = new TriggerKey(triggerName,triggerGroup);
            Trigger trigger = scheduler.getTrigger(triggerKey);
            TriggerBuilder triggerBuilder = trigger.getTriggerBuilder();
            triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cronExpress));
            //停止当前任务
            scheduler.unscheduleJob(triggerKey);
            //开启新任务
            scheduler.scheduleJob(jobDetail,triggerBuilder.build());
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
