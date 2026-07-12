package com.JobPortal.demo.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    public static final Logger logger= LoggerFactory.getLogger(LoggingAspect.class);

   @Before("execution(* com.JobPortal.demo.Service.JobService.*(..))")
    public void methodcalled(JoinPoint jp){
        logger.info("Method is Called "+jp.getSignature().getName());
    }

}
