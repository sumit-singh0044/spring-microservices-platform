package com.user.userinfo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAspect {

    private static final Logger log = LoggerFactory.getLogger(LoginAspect.class);

    @Before("execution( * com.user.userinfo.service.UserService.saveUser(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println("Before method: " + joinPoint.getSignature().getName());

        log.info("Before method: " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.user.userinfo.service.UserService.saveUser(..))")
    public void after(JoinPoint joinPoint) {
        System.out.println("After method completed: " + joinPoint.getSignature().getName() + " Exception");
        log.info("After method: " + joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* com.user.userinfo.service.UserService.saveUser(..))")
    public void afterReturning(JoinPoint joinPoint) {
        System.out.println("After returning from method: " + joinPoint.getSignature().getName());
        log.info("After returning from method: " + joinPoint.getSignature().getName());
    }

}
