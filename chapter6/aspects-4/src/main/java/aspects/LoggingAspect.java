package aspects;

import java.util.Arrays;
import java.util.logging.Logger;

import jakarta.annotation.PostConstruct;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger;

    @Around("@annotation(ToLog)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        // Get the method name being intercepted.
        String methodName = joinPoint.getSignature().getName();

        // Get the arguments of the intercepted method.
        Object[] args = joinPoint.getArgs();

        // Log this metadata.
        logger.info("Executing method: " + methodName + " with args: " + Arrays.toString(args));

        // Delegate to the target object.
        Object result = joinPoint.proceed();

        // Log the result returned.
        logger.info("Method executed and returned: " + result);
        return result;
    }

    @PostConstruct
    public void init() {
        logger = Logger.getLogger(LoggingAspect.class.getName());
    }
}
