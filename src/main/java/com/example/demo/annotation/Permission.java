package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * @Description Permission annotation
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Permission {
    String auth() default "user";
}
