package com.honorzhang.quartzdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: quartz-demo
 * @author: zgr
 * @create: 2020-03-25 23:32
 **/
@Service
@Slf4j
public class JobService implements InterruptableJob {

    private boolean isInterrupt = false;
    private JobKey jobKey = null;


    @Override
    public void interrupt() throws UnableToInterruptJobException {
        log.info("出现异常，需要中断当前操作");
        isInterrupt = true;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        //这个是具体的任务
        jobKey = jobExecutionContext.getJobDetail().getKey();

        try {

            System.out.println("********************************************");
            System.out.println("********************************************");
            System.out.println("********************************************");
            Thread.sleep(5 * 1000L);


            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println("%%%%%%%%：" + sdf.format(new Date()));



            // 查看是否中断
            if (isInterrupt) {
                log.info("*******任务被中断***********");
                return; // 也可以选择抛出一个JobExecutionException，根据业务需要指定行为
            }


        }catch (Exception e){
            log.error("执行任务异常");
        }
        finally {
            System.out.println("任务完成时间：" + sdf.format(new Date()));
        }
    }
}
