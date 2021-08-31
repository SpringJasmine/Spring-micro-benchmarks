package com.example.demo.service.impl;

import com.example.demo.service.PrototypeDIServiceC;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service//Use @Service annotation
@Scope(value = "prototype")//Unlike the singleton mode of TestService3Impl, the prototype mode is used here.
public class PrototypeDIServiceCImpl implements PrototypeDIServiceC {
    @Override
    public void print() {
        System.out.println("PrototypeDIServiceCImpl.print()");
    }
}
