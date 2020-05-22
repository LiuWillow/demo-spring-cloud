package com.lwl.democlient.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * author liuweilong
 * date 2020/5/18 2:43 下午
 * desc
 */
//@Aspect
//@Component
public class MyAspect {
    @Pointcut("execution(public * com.lwl.democlient.service.MessageService.*(..))")
    public void privilege(){}

    @Around("privilege()")
    public Object handle(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("sdfsdfdsf");
        return joinPoint.proceed(joinPoint.getArgs());
    }
}
