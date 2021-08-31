package com.example.demo.service.impl;

import com.example.demo.service.PrototypeDIServiceD;


//Do not use the @Service annotation for registration, but use XML for configuration. And unlike TestService2Impl in singleton mode, TestService4Impl uses prototype mode in XML registration.
public class PrototypeDIServiceDImpl implements PrototypeDIServiceD {
    @Override
    public void print() {
        System.out.println("PrototypeDIServiceDImpl.print()");
    }
}
