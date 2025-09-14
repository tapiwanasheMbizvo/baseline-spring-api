package com.tapiwanashe.mbizvo.baseline.api.controllers.exceptionHandlers;

import com.tapiwanashe.mbizvo.baseline.api.dto.ApiResponse;
import com.tapiwanashe.mbizvo.baseline.api.exceptions.EmailAlreadyTakenException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyTakenException.class)
    public ApiResponse<?> handleEmailAlreadyTaken(EmailAlreadyTakenException ex) {

        return ApiResponse.builder()
                .message(ex.getMessage())
                .data(Map.of("error", ex.getMessage()))
                .status(HttpStatus.BAD_REQUEST)
                .timestamp(LocalDateTime.now())
                .build();

    }
}
