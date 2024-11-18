package com.proj.spring_boot_rest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    @Around("execution(* com.proj.spring_boot_rest.service.JobService.*(..))")
    public Object monitorTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object object = pjp.proceed();
        long end = System.currentTimeMillis();

        LOGGER.info("Time Taken by " + pjp.getSignature().getName() + ": " + (end - start) + " ms");

        return object;
    }

}
