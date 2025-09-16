package com.tapiwanashe.mbizvo.baseline.api.services.impl;

import com.tapiwanashe.mbizvo.baseline.api.config.RabbitConfig;
import com.tapiwanashe.mbizvo.baseline.api.dto.ISOMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    private final RabbitTemplate rabbitTemplate;

    public MessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(ISOMessage message) {
        rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_NAME, message);
        System.out.println("Sent: " + message);
    }
}
