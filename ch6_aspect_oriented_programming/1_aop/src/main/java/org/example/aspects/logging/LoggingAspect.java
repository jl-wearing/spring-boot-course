package org.example.aspects.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* org.example.services.*.*(..))")
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
        // Before the method executes.
        logger.info("Method will execute: " + joinPoint.getSignature().getName());

        // Delegate to the actual method.
        joinPoint.proceed();

        // After the method executes.
        logger.info("Method executed");
    }
}
