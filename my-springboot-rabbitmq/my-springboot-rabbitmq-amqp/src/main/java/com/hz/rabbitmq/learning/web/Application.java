package com.hz.rabbitmq.learning.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @ClassName: Application
 * @Description:
 * @author: Gordon.Zhang HomeCredit
 * @date: 2021/4/9 11:15
 */

@EnableCaching
@SpringBootApplication
@EnableScheduling
@PropertySource(value = {"classpath:first-mq-config.properties", "classpath:second-mq-config.properties"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
