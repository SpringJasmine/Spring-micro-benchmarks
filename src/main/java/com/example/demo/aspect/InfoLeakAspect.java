package com.example.demo.aspect;

import com.example.demo.tag.InfoLeakTag;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @Description infoLeak Aspect
 */
@Aspect
@Component
public class InfoLeakAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(InfoLeakAspect.class);

    @Pointcut("execution(public * *..InfoLeakService.infoLeakMethod(..))")
    public void webLog1() {
    }

    @InfoLeakTag(description = "2")
    @Around("webLog1()")
    public Object aroundMethod(ProceedingJoinPoint pdj) {
        Object result = null;
        /*before advice*/
        System.out.println("InfoLeakAspect @Around get parameter: " + Arrays.asList(pdj.getArgs()));

        /*Execution target method*/
        try {
            result = pdj.proceed();
            /*after advice*/
            System.out.println("InfoLeakAspect @Around get result: " + result);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return result;
    }

    @InfoLeakTag(description = "")
    @Before("webLog1()")
    public void doBefore(JoinPoint joinPoint) {
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("InfoLeakAspect @Before get parameter: " + args);
    }

    @InfoLeakTag(description = "")
    @After(value = "webLog1()")
    public void doAfter(JoinPoint joinPoint) {
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("InfoLeakAspect @After get parameter: " + args);
    }

    @InfoLeakTag(description = "")
    @AfterReturning(value = "webLog1()", returning = "result")
    public void afterReturning(JoinPoint point, Object result) {
        List<Object> args = Arrays.asList(point.getArgs());
        System.out.println("InfoLeakAspect @AfterReturning get parameter:" + args + " and result: " + result);
    }
}
