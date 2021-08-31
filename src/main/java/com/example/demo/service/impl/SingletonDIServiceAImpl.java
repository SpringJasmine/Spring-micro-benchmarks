package com.example.demo.service.impl;

import com.example.demo.service.SingletonDIServiceA;
import org.springframework.stereotype.Service;


@Service//Use @Service annotation
public class SingletonDIServiceAImpl implements SingletonDIServiceA {
    @Override
    public void print() {
        System.out.println("SingletonDIServiceAImpl.print()");
    }
}
