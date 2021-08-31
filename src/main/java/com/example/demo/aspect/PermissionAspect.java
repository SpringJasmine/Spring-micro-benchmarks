package com.example.demo.aspect;

import com.example.demo.annotation.Permission;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Description Permission access control aspect
 */
@Aspect
@Component
public class PermissionAspect {
    // Indicates that the Permission method is used as the entry point, and talkSome is used as the enhanced proxy method. The next several notification types are all directed to talkSome, which is equivalent to indirectly enhancing Permission.
    @Pointcut("@annotation(com.example.demo.annotation.Permission)")
    public void doSome() {
    }

    @Around("doSome()")
    public Object aroundMethod(ProceedingJoinPoint pdj) {
        MethodSignature sign = (MethodSignature) pdj.getSignature();
        Method method = sign.getMethod();
        Permission permission = method.getAnnotation(Permission.class);
        System.out.println("method = " + method);
        Object result = null;

        /*Execution target method*/
        try {
            if (permission.auth().equals(pdj.getArgs()[0]) || pdj.getArgs()[0].equals("admin")) {
                result = pdj.proceed();
            } else {
                System.out.println("Unable to access the method, no permission");
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return result;
    }
}
