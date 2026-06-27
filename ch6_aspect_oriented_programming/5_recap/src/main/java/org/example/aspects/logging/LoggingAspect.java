package org.example.aspects.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger LOGGER = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* org.example.services.CommentService.publishComment(..))")
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
        // Get the method name.
        String methodName = joinPoint.getSignature().getName();
        // Get the method arguments.
        Object[] args = joinPoint.getArgs();

        // Log information about the method.
        LOGGER.info("About to execute method: " + methodName
        + " with args: " + Arrays.toString(args));

        // Delegate to the actual method.
        joinPoint.proceed();

        // Log information after the method call.
        LOGGER.info("Execution complete");
    }

    @Around("@annotation(ToLog)")
    public void logDelete(ProceedingJoinPoint joinPoint) throws Throwable {
        // Get the method name.
        String methodName = joinPoint.getSignature().getName();
        // Get the method arguments.
        Object[] args = joinPoint.getArgs();

        LOGGER.info("Deleting comment with: " + methodName
        + " with args: " + Arrays.toString(args));
        joinPoint.proceed();
    }
}
