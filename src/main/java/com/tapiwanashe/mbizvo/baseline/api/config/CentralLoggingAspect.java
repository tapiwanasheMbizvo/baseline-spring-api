package com.tapiwanashe.mbizvo.baseline.api.config;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import java.util.UUID;

@Aspect
@Component
@Slf4j
public class CentralLoggingAspect {

    // Intercept all public methods in controllers
    @Around("execution(public * com.tapiwanashe.mbizvo.baseline.api.controllers..*(..))")
    public Object logController(ProceedingJoinPoint joinPoint) throws Throwable {
        RequestAttributes attrs = RequestContextHolder.getRequestAttributes();
        String requestId = UUID.randomUUID().toString(); // Generate request ID for tracing
        if (attrs instanceof ServletRequestAttributes servletAttrs) {
            HttpServletRequest request = servletAttrs.getRequest();
            log.info("[{}] Incoming request: {} {} with args={}", requestId, request.getMethod(), request.getRequestURI(), joinPoint.getArgs());
        }

        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long elapsed = System.currentTimeMillis() - start;

        log.info("[{}] Response from {}.{}(): {} ({} ms)", requestId,
                joinPoint.getTarget().getClass().getSimpleName(),
                joinPoint.getSignature().getName(),
                result,
                elapsed);
        return result;
    }

    // Intercept all public methods in services
    @Around("execution(public * com.tapiwanashe.mbizvo.baseline.api.services..*(..))")
    public Object logService(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();

        log.info("Service entry: {}.{}() with args={}", className, methodName, joinPoint.getArgs());

        long start = System.currentTimeMillis();
        Object result;
        try {
            result = joinPoint.proceed();
        } catch (Exception ex) {
            log.error("Exception in {}.{}(): {}", className, methodName, ex.getMessage(), ex);
            throw ex;
        }
        long elapsed = System.currentTimeMillis() - start;
        log.info("Service exit: {}.{}() with result={} ({} ms)", className, methodName, result, elapsed);

        return result;
    }

}