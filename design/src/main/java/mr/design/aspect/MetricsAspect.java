package mr.design.aspect;

import lombok.extern.slf4j.Slf4j;
import mr.design.util.MetricsStorage;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class MetricsAspect {

    @Autowired
    MetricsStorage metricsStorage;


    @Pointcut("execution(public * mr.design.controller..*.*(..))")
    public void controller(){}

    @Before("controller()")
    public void doBefore(JoinPoint joinPoint){
        if (joinPoint instanceof MethodInvocationProceedingJoinPoint) {
            MethodInvocationProceedingJoinPoint methodJoinPoint = (MethodInvocationProceedingJoinPoint)joinPoint;
        }
        log.info("aspect");
    }
}
