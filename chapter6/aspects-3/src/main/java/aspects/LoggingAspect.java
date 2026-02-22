package aspects;

import jakarta.annotation.PostConstruct;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import models.Comment;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger;

    @Around("execution(* services.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        // Get the intercepted method name.
        String methodName = joinPoint.getSignature().getName();

        // Get the method's arguments.
        Object[] args = joinPoint.getArgs();

        // Log the method information.
        logger.info("About to call: " + methodName +
                " with args: " + Arrays.toString(args));

        // Altering the argument of the intercepted method.
        Comment comment = new Comment();
        comment.setText("Some other text!");
        comment.setAuthor("A different author");
        Object[] newArgs = {comment};
        // Send a different comment instance to the intercepted method.
        Object result = joinPoint.proceed(newArgs);

        // Log the result.
        logger.info("Method executed and returned: " + result);

        // We logged the return value of the intercepted method, but we return a different method to the caller.
        return "FAILED";
    }

    @PostConstruct
    public void init() {
        logger = Logger.getLogger(LoggingAspect.class.getName());
    }
}
