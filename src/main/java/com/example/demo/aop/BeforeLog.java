package com.example.demo.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Description an AOP before Method
 */
public class BeforeLog implements MethodBeforeAdvice {
    /**
     *
     * @param method The method of the target object to be executed
     * @param objects Method parameters
     * @param o target
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Method " + method.getName() + " of " + o.getClass().getName() + "is executed");
    }
}
