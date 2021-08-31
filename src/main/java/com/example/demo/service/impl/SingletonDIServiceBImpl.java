package com.example.demo.service.impl;

import com.example.demo.service.SingletonDIServiceB;


//Do not use the @Service annotation for registration, but use XML for configuration.
public class SingletonDIServiceBImpl implements SingletonDIServiceB {
    @Override
    public void print() {
        System.out.println("SingletonDIServiceBImpl.print()");
    }
}
