package com.tapiwanashe.mbizvo.baseline.api.services.impl;

import com.tapiwanashe.mbizvo.baseline.api.config.RabbitConfig;
import com.tapiwanashe.mbizvo.baseline.api.dto.ISOMessage;
import com.tapiwanashe.mbizvo.baseline.api.entity.IsoMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageConsumer {

    private final  IsoMessageService messageService;
    @RabbitListener(queues = RabbitConfig.QUEUE_NAME)
    public void receiveMessage(ISOMessage message) {

        messageService.createMessage(message);
        System.out.println("Received: " + message);
    }
}
