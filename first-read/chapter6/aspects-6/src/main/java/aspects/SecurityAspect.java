package aspects;

import jakarta.annotation.PostConstruct;
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
    private Logger logger;

    @Around(value = "@annotation(ToLog)")
    public Object secure(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Security Aspect: Calling the intercepted method.");

        // Log the data returned.
        Object returnValue = joinPoint.proceed();
        logger.info("Security Aspect: Method executed and returned: " + returnValue);
        return returnValue;
    }

    @PostConstruct
    public void init() {
        logger = Logger.getLogger(LoggingAspect.class.getName());
    }
}
