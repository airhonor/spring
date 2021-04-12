package com.honorzhang.quartzdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobKey;
import org.quartz.SchedulerMetaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: quartz-demo
 * @author: zgr
 * @create: 2020-03-25 23:33
 **/
@Service
@Slf4j
public class InterruptConditionService{
    @Autowired
    private ScheduleService scheduleService;

    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        try {
            log.info("^^^^^^启动中断^^^^^^");
            log.info("当前时间{}", sdf.format(new Date()));


            scheduleService.JobInterrupt();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
