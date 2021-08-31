package com.example.demo.aspect;

/**
 * @Description an AOP Aspect class,use xml configuration
 */
public class AopXmlAspect {
    public void doBefore() {
        System.out.println("before AopXmlTestBean doSomething");
    }

    public void doAfter() {
        System.out.println("after AopXmlTestBean doSomething");
    }
}
