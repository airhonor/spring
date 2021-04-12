package com.honorzhang.code.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Administrator
 * @date 2016/11/18
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ScoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScoreApplication.class);
    }

}