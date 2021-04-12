package com.hz.rabbitmq.learning.web.consumer;


import com.hz.rabbitmq.learning.model.entity.RabbitMqMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @ClassName: MqMsgConsumer
 * @Description:
 * @author: Gordon.Zhang HomeCredit
 * @date: 2021/4/9 14:46
 */
@Slf4j
@Component
public class MqMsgConsumer {


    @RabbitListener(queues =  "${spring.rabbitmq.first.queue.name}",  containerFactory="firstFactory")
    public void processFirstMqMessage(@Payload RabbitMqMsg message) {
        log.info("**********processMessage first message****************: {}", message);
    }


    @RabbitListener(queues =  "${spring.rabbitmq.second.queue.name}",  containerFactory="secondFactory")
    public void processSecondMqMessage(@Payload RabbitMqMsg message) {
        log.info("**********processMessage second message***********: {}", message);
    }
}
