package org.example.aspects.security;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
@Order(1)
public class SecurityAspect {
    private static final Logger LOGGER = Logger.getLogger(SecurityAspect.class.getName());

    @Around(value = "@annotation(org.example.aspects.ToLog)")
    public Object secure(ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.info("Security Aspect: Calling the intercepted method.");
        Object returnValue = joinPoint.proceed();
        LOGGER.info("Security Aspect: Method executed and returned: " + returnValue);
        return returnValue;
    }
}
