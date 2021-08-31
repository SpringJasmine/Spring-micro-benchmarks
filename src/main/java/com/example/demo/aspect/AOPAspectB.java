package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Description an AOP Aspect class,use @Aspect annotation
 */
@Aspect
@Order(3)
@Component
public class AOPAspectB {

    private static final Logger LOGGER = LoggerFactory.getLogger(AOPAspectB.class);

    @Pointcut("execution(public * com.example.demo.service.impl.AOPServiceImpl.testAOPAnno2(..))")
    public void webLog1() {
    }

    @Around("webLog1()")
    public Object aroundMethod(ProceedingJoinPoint pdj) {
        System.out.println("AOPAspectB @Around2 Before");
        Object result = null;

        /*Execution target method*/
        try {
            result = pdj.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        /*after advice*/
        System.out.println("AOPAspectB @Around2 After");
        return result;
    }

    @Before("webLog1()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("AOPAspectB @Before");
    }

    @After(value = "webLog1()")
    public void doAfter(JoinPoint joinPoint) {
        System.out.println("AOPAspectB @After");
    }

    @AfterReturning(value = "webLog1()", returning = "result")
    public void afterReturning(JoinPoint point, Object result) {
        System.out.println("AOPAspectB @AfterReturning");
    }
}
