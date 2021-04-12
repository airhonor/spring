package com.honorzhang.quartzdemo.service;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: quartz-demo
 * @author: zgr
 * @create: 2020-04-03 17:11
 **/
@Service
public class PrintInfoService {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void printStar() throws InterruptedException {
        System.out.println("********************************************");
        System.out.println("********************************************");
        System.out.println("********************************************");
        Thread.sleep(10 * 1000);

    }

    public void printPercent(){
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("%%%%%%%%：" + sdf.format(new Date()));

    }
}
