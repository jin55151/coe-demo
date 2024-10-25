package com.coe.aop.demo1.aspect;

import java.util.Date;
import java.util.Random;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {
    static long startTime;

    // @Before("execution(* createAccount(..))")
    // public void beforeExecuteAdvice() {
    //     System.out.println("Start executing createAccount(..) ...");
        
    //     // Store start time
    //     Date now  = new Date();
    //     startTime =  now.getTime();

    //     // Dummy sleep
    //     long randomTime = new Random().nextLong(5000);
    //     try {
    //         Thread.sleep(randomTime);
    //     } catch (InterruptedException e) {
    //         e.printStackTrace();
    //     }
    // }

    // @After("execution(* createAccount(..))")
    // public void afterExecuteAdvice() {
    //     System.out.println("End of createAccount(..).");

    //     // Caculate execute time
    //     Date now  = new Date();
    //     long execTime = now.getTime() - startTime;

    //     System.out.println("Execute time is: " + execTime);
    // }

    @Around("execution(* createAccount(..))")
    public void aroundExecuteAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Before execution of createAccount(..).");
        Date now  = new Date();
        startTime =  now.getTime();
        
        // continue process
        proceedingJoinPoint.proceed();

        System.out.println("After execution of createAccount(..).");
        now  = new Date();
        long execTime = now.getTime() - startTime;
        System.out.println("Execute time is: " + execTime);
    }
}
