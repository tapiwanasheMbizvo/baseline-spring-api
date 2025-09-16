package com.tapiwanashe.mbizvo.baseline.api.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ISOMessage implements Serializable {

    private static final long serialVersionUID = 1L;
    private String messageHeader;
    private String messageBody;
}
