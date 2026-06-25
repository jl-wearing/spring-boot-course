package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import java.util.logging.Logger;
import java.util.Arrays;

@Aspect
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* services.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        // Get the method name
        String methodName = joinPoint.getSignature().getName();

        // Get the arguments of the method.
        Object[] arguments = joinPoint.getArgs();

        // Log details to the console.
        logger.info("Method: " + methodName +
                " with arguments: " + Arrays.toString(arguments)
         + " will execute");

        // Get the value returned by the intercepted method.
        Object returnedByMethod = joinPoint.proceed();
        // Log the object returned.
        logger.info("Method executed and returned: " + returnedByMethod);

        return returnedByMethod;
    }
}
