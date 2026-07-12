package com.JobPortal.demo.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitoring {
    public static final Logger logger= LoggerFactory.getLogger(PerformanceMonitoring.class);

    @Around("execution(* com.JobPortal.demo.Service.*.*(..))")
    public Object performanceCal(ProceedingJoinPoint jp) throws Throwable {

        long Start=System.currentTimeMillis();
        Object ob=jp.proceed();
        long end=System.currentTimeMillis();

        logger.info(end-Start+"ms");
        return ob;
    }
}
