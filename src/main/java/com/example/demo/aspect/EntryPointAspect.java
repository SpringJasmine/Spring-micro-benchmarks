package com.example.demo.aspect;

import com.example.demo.utils.PrintStack;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Description Aspect of EntryPoint
 */
@Aspect
@Component
public class EntryPointAspect {
    @Pointcut("execution(public * com.example.demo.controller.EntryPointWithAOPController.entryPoint3(..))")
    public void log() {
        System.out.println("EntryPointAspect log");
        PrintStack.printStack();
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("----- entryPointAspect doBefore -----");
    }
}
