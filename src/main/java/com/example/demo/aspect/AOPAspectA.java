package com.example.demo.aspect;

import com.example.demo.tag.AOPCheckTag;
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
@Order(1)
@Component
public class AOPAspectA {

    private static final Logger LOGGER = LoggerFactory.getLogger(AOPAspectA.class);

    @Pointcut("execution(public * com.example.demo.service.AOPService.testAOPAnno*(..))")
    public void webLog1() {
    }

    @AOPCheckTag(description = "around method processing")
    @Around("webLog1()")
    public Object aroundMethod(ProceedingJoinPoint pdj) {
        System.out.println("AOPAspectA @Around2 Before");
        Object result = null;

        /*Execution target method*/
        try {
            result = pdj.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        /*after advice*/
        System.out.println("AOPAspectA @Around2 After");
        return result;
    }

    @AOPCheckTag(description = "before method processing")
    @Before("webLog1()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("AOPAspectA @Before");
    }

    @AOPCheckTag(description = "after method processing")
    @After(value = "webLog1()")
    public void doAfter(JoinPoint joinPoint) {
        System.out.println("AOPAspectA @After");
    }

    @AOPCheckTag(description = "AfterReturning method processing")
    @AfterReturning(value = "webLog1()", returning = "result")
    public void afterReturning(JoinPoint point, Object result) {
        System.out.println("AOPAspectA @AfterReturning");
    }
}
