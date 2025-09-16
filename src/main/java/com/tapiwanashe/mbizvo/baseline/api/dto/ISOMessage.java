package com.tapiwanashe.mbizvo.baseline.api.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class ISOMessage implements Serializable {

    public ISOMessage() {}

    private static final long serialVersionUID = 1L;
    private String messageHeader;
    private String messageBody;
}
