package com.cm.schedule;

import com.cm.utils.ScheduleUtils;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class BuySchedule {

    public static void main(String[] args) {
        buyJobCronScedule();
    }

    /**
     * 按照cron来调°任务
     */
    private static void buyJobCronScedule() {
        try {
            Scheduler scheduler  = StdSchedulerFactory.getDefaultScheduler();
            JobDataMap jobDataMap = new JobDataMap();
            jobDataMap.put("money",100.0);
            jobDataMap.put("thing","book");
            JobDetail jobDetail = JobBuilder.newJob(BuyJob.class)
                    .withIdentity("buyJob","group1")
                    .setJobData(jobDataMap)
                    .build();
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("buyJobTrigger","group1")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ? 2018"))
                    .build();
            scheduler.start();
            scheduler.scheduleJob(jobDetail,trigger);

            Thread.sleep(10*1000);
            //修改任务调度
            ScheduleUtils.change("buyJob","group1","buyJobTrigger","group1","0/2 * * * * ? 2018");
        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /***
     * 按照SimpleScheduleBuilder来调度任务
     */
    private static void buyJobScedule() {
        try {
            Scheduler scheduler  = StdSchedulerFactory.getDefaultScheduler();
            JobDataMap jobDataMap = new JobDataMap();
            jobDataMap.put("money",100.0);
            jobDataMap.put("thing","book");
            JobDetail jobDetail = JobBuilder.newJob(BuyJob.class)
                    .withIdentity("buyJob","group1")
                    .setJobData(jobDataMap)
                    .build();
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("buyJobTrigger","group1")
                    .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(5))
                    .build();
            scheduler.start();
            scheduler.scheduleJob(jobDetail,trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
