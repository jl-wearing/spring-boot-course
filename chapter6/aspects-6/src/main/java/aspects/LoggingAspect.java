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
@Order(2)
public class LoggingAspect {
    private Logger logger;

    @PostConstruct
    public void init() {
        logger = Logger.getLogger(LoggingAspect.class.getName());
    }

    @Around(value = "@annotation(ToLog)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Logging Aspect: Calling the intercepted method.");

        // Log the data returned.
        Object returned = joinPoint.proceed();
        logger.info("Logging Aspect: Method executed and returned: " + returned);
        return returned;
    }
}
