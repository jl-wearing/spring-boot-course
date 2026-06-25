package aspects;

import jakarta.annotation.PostConstruct;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger;

    @Around("execution(* services.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        // Get the parameters of the intercepted method.
        Object[] args = joinPoint.getArgs();

        // Get the method name intercepted.
        String methodName = joinPoint.getSignature().getName();

        // Log the method name and arguments supplied.
        logger.info("Method: " + methodName +
                " with args: " + Arrays.toString(args));

        // Get the return value of the method.
        Object result = joinPoint.proceed();
        if (result instanceof String) {
            logger.info("Method executed and returned: " + (String)result);

        }

        return result;
    }

    @PostConstruct
    public void init() {
        logger = Logger.getLogger(LoggingAspect.class.getName());
    }
}
