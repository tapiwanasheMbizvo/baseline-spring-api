package com.tapiwanashe.mbizvo.baseline.api.controllers;
import com.tapiwanashe.mbizvo.baseline.api.dto.ISOMessage;
import com.tapiwanashe.mbizvo.baseline.api.services.impl.MessageProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageProducer messageProducer;

    public MessageController(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam ISOMessage msg) {
        messageProducer.sendMessage(msg);
        return "Message sent: " + msg;
    }
}
