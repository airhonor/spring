package com.hz.rabbitmq.learning.model.entity;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName: RabbitMqMsg
 * @Description:
 * @author: Gordon.Zhang HomeCredit
 * @date: 2021/4/12 10:35
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RabbitMqMsg implements Serializable {
    private String msgId;

    private String msgText;
}
