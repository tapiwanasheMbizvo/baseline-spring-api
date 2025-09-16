package com.tapiwanashe.mbizvo.baseline.api.services.impl;

import com.tapiwanashe.mbizvo.baseline.api.config.RabbitConfig;
import com.tapiwanashe.mbizvo.baseline.api.dto.ISOMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageProducer {

    private final RabbitTemplate rabbitTemplate;
    private final  IsoMessageService messageService;



    public void sendMessage(ISOMessage message) {
        rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_NAME, message);
        messageService.createMessage(message);
    }
}
