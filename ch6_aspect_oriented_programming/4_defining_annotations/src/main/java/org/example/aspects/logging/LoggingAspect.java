package org.example.aspects.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = Logger.getLogger(LoggingAspect.class.getName());

    @Around("@annotation(ToLog)")
    public void log(ProceedingJoinPoint joinPoint) throws Throwable{
        // Get the name of the method.
        String methodName = joinPoint.getSignature().getName();

        // Get the arguments of the method.
        Object[] args = joinPoint.getArgs();

        // Log information about the method.
        LOGGER.info("Executing " + methodName + " with args: " + Arrays.toString(args));
        joinPoint.proceed();
    }

    @AfterReturning(returning = "returnedValue", value = "execution(* org.example.services.CommentService.getComment(..))")
    public Object log(Object returnedValue) throws Throwable {
        LOGGER.info("Returning " + returnedValue);
        return returnedValue;
    }
}
