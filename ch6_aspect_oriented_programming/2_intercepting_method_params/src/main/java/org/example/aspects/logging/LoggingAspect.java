package org.example.aspects.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Component
@Aspect
public class LoggingAspect {
    private final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* org.example.services.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        // Get the method name.
        String methodName = joinPoint.getSignature().getName();

        // Get the arguments of the method.
        Object[] args = joinPoint.getArgs();

        // Log information about the method.
        logger.info("Method " + methodName + " with args: " + Arrays.asList(args) + " will execute.");

        // Get the returned value.
        Object result = joinPoint.proceed();

        // Log the returned value.
        logger.info("Method executed and returned: " + result);
        return result;
    }
}
