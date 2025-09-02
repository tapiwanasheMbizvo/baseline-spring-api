package com.tapiwanashe.mbizvo.baseline.api.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


@Builder
@Data
public class ApiResponse<T> {

    private  T data;
    private HttpStatus status;
    private String message;
    private LocalDateTime timestamp;
}
