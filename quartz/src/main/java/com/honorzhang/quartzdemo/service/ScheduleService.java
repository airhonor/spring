package com.honorzhang.quartzdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.quartz.DateBuilder.nextGivenSecondDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @program: quartz-demo
 * @author: zgr
 * @create: 2020-03-26 10:00
 **/
@Service
@Slf4j
public class ScheduleService {
    private Scheduler sched;
    private JobKey jobKey = null;

    @Autowired
    private PrintInfoService printInfoService;


    @PostConstruct
    public  void ini() throws SchedulerException {
        SchedulerFactory sf = new StdSchedulerFactory();
         sched = sf.getScheduler();


    }


    public void runScheduleJob()throws Exception {


        JobDetail job = newJob(JobService.class).withIdentity(
                "interruptableJob1", "group1").build();
        job.getJobDataMap().put("print", printInfoService);
        SimpleTrigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(simpleSchedule().repeatForever().withIntervalInSeconds(10))
                .build();

        jobKey = job.getKey();
        if (sched.checkExists(jobKey)){
            sched.deleteJob(jobKey);
        }

        Date ft = sched.scheduleJob(job, trigger);
        // 调度开始执行
        sched.start();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(job.getKey() + " 将运行于：" + sdf.format(ft) + " 并重复："
                + trigger.getRepeatCount() + " 次，间隔 "
                + trigger.getRepeatInterval() / 1000 + " 秒");




    }

    public void JobInterrupt() throws SchedulerException {
        sched.pauseJob(jobKey);
        log.info("&&&&&&&任务被暂停&&&&&&&&&");
    }


}
