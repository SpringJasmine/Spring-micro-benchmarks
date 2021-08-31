package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @Description Aspect of getField
 */
@Aspect
@Component
public class GetFieldAspect {
    @Before("execution(public * com.example.demo.service.impl.GetFieldWithAOPServiceImpl.*(..))")
    public void doAccessCheck() {
        System.out.println("----- getFieldAspect doAccessCheck -----");
    }
}
