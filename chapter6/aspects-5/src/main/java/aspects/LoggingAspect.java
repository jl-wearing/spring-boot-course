package aspects;

import jakarta.annotation.PostConstruct;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger;

    @AfterReturning(value = "@annotation(ToLog)", returning = "returnValue")
    public void log(Object returnValue) {
        logger.info("Method executed and returned: " + returnValue);
    }

    @PostConstruct
    public void init() {
        logger = Logger.getLogger(LoggingAspect.class.getName());
    }
}
