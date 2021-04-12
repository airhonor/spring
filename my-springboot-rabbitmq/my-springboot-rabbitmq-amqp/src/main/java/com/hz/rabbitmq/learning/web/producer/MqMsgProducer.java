package com.hz.rabbitmq.learning.web.producer;

import com.hz.rabbitmq.learning.model.entity.RabbitMqMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName: MqMsgProducer
 * @Description:
 * @author: Gordon.Zhang HomeCredit
 * @date: 2021/4/9 14:39
 */

@Component
@Slf4j
public class MqMsgProducer {

    @Resource(name = "firstRabbitTemplate")
    private RabbitTemplate firstRabbitTemplate;

    @Resource(name = "secondRabbitTemplate")
    private RabbitTemplate secondRabbitTemplate;

    @Value("${spring.rabbitmq.first.exchange:@null}")
    private String firstExchange;

    @Value("${spring.rabbitmq.first.routing.key:@null}")
    private String firstRoutingKeyRoute;

    @Value("${spring.rabbitmq.second.exchange:@null}")
    private String secondExchange;

    @Value("${spring.rabbitmq.second.routing.key:@null}")
    private String secondRoutingKeyRoute;




    public void sendMessageByFirstMq() {
        RabbitMqMsg rabbitMqMsg = constructMqMsg("first", "**********first**********");
        log.info("-------------------send first rabbit mq info-----------------");
        firstRabbitTemplate.convertAndSend(
                firstExchange, firstRoutingKeyRoute, rabbitMqMsg, generateMqHeader());

    }

    public void sendMessageBySecondMq() {
        RabbitMqMsg rabbitMqMsg = constructMqMsg("second", "**********second**********");
        log.info("-------------------send second rabbit mq info-----------------");
        secondRabbitTemplate.convertAndSend(secondExchange, secondRoutingKeyRoute, rabbitMqMsg, generateMqHeader());
    }

    private RabbitMqMsg constructMqMsg(String id, String text) {

        return RabbitMqMsg.builder()
                .msgId(id)
                .msgText(text)
                .build();

    }


    private MessagePostProcessor generateMqHeader() {
        return message -> {
            MessageProperties properties = message.getMessageProperties();
            properties.setHeader("content-type", "application/json");
            properties.setHeader("content-encoding", "UTF-8");
            return message;
        };
    }


    @Scheduled(fixedRate = 30 * 1000L)
    public void sendMessage(){
        sendMessageByFirstMq();
        sendMessageBySecondMq();

    }
    
}
