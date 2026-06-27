package org.example.aspects.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class LoggingAspect {
    private static final Logger LOGGER = Logger.getLogger(LoggingAspect.class.getName());

    @Around(value = "@annotation(org.example.aspects.ToLog)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.info("Logging Aspect: Calling the intercepted method.");
        // Get the return value.
        Object returnValue = joinPoint.proceed();
        LOGGER.info("Logging Aspect: Method executed and returned: " + returnValue);
        return returnValue;
    }
}
