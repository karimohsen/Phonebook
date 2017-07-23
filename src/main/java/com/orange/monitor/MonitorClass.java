package com.orange.monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by Karim on 7/11/2017.
 */
@Component
@Aspect
public class MonitorClass {
    private static final Logger logger = LoggerFactory.getLogger(MonitorClass.class);

    @Before("execution(* com..*Service.*(..)) || execution(* com..*Controller.*(..))")
    public void loggingMethod(JoinPoint joinPoint) {
        logger.debug("the method being executed is : " + joinPoint.getSignature().getName());
        logger.debug("the method being executed arguments are : " + Arrays.toString(joinPoint.getArgs()));
        logger.info("the method being executed is : " + joinPoint.getSignature().getName());
        logger.info("the method being executed arguments are : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterThrowing(pointcut = "execution(* com..*Service.*(..)) || execution(* com..*Controller.*(..))", throwing = "e")
    public void errorLoggingMethod(JoinPoint joinPoint, Throwable e) {
        logger.debug("error did occur in  : " + joinPoint.getSignature().getName() + " exception was " + e.getMessage());
        logger.info("error did occur in : " + joinPoint.getSignature().getName() + " exception was " + e.getMessage());
    }

}
