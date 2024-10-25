package com.coe.aop.demo1.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {

    @Before("execution(* addAccount(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("Executing before advice of addAccount() ...");
    }
}
