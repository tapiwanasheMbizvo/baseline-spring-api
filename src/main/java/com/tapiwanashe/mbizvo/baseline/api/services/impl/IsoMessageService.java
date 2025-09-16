package com.tapiwanashe.mbizvo.baseline.api.services.impl;

import com.tapiwanashe.mbizvo.baseline.api.dto.ISOMessage;
import com.tapiwanashe.mbizvo.baseline.api.entity.IsoMessage;
import com.tapiwanashe.mbizvo.baseline.api.repositories.IsoMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IsoMessageService {

    private final IsoMessageRepository isoMessageRepository;

    public IsoMessage createMessage(ISOMessage isoMessage) {

        var isoMessageEntity = new IsoMessage();
        isoMessageEntity.setMessageHeader(isoMessage.getMessageHeader());
        isoMessageEntity.setMessageBody(isoMessage.getMessageBody());
        return  isoMessageRepository.save(isoMessageEntity);
    }
}
