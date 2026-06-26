package org.example.aspects.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.models.Comment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* org.example.services.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        // Get the name of the method.
        String methodName = joinPoint.getSignature().getName();

        // Get the arguments of the method.
        Object[] args = joinPoint.getArgs();

        // log the information about the method.
        LOGGER.info("Method: " + methodName + " with parameters: " + Arrays.toString(args) + " will execute.");

        // Define a different argument for the intercepted method.
        Comment comment = new Comment();
        comment.setAuthor("INTERCEPT");
        comment.setText("GET INTERCEPTED JERKWAD");
        Object[] newArgs = {comment};

        // Get the returned value.
        Object returnValue = joinPoint.proceed(newArgs);

        // we log the value returned by the intercepted method.
        LOGGER.info("Method executed and returned: " + returnValue);

        // Alter the return value
        return "FAILED";
    }
}
