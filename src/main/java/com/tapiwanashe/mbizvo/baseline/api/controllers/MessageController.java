package com.tapiwanashe.mbizvo.baseline.api.controllers;
import com.tapiwanashe.mbizvo.baseline.api.dto.ApiResponse;
import com.tapiwanashe.mbizvo.baseline.api.dto.ISOMessage;
import com.tapiwanashe.mbizvo.baseline.api.services.impl.MessageProducer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageProducer messageProducer;

    public MessageController(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @PostMapping("/send")
    public ApiResponse<?> sendMessage(@RequestBody ISOMessage msg) {
        messageProducer.sendMessage(msg);

        return  ApiResponse.builder()
                .message("Message sent successfully")
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.OK)
                .build();
    }
}
