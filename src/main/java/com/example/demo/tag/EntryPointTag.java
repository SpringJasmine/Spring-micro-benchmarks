package com.example.demo.tag;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.SOURCE)
public @interface EntryPointTag {
    String description();
}
