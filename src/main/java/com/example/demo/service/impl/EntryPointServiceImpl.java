package com.example.demo.service.impl;

import com.example.demo.service.EntryPointService;
import org.springframework.stereotype.Service;


@Service
public class EntryPointServiceImpl implements EntryPointService {
    @Override
    public void invokeMethod1() {
        System.out.println("call invokeMethod1");
    }

    @Override
    public void invokeMethod2() {
        System.out.println("call invokeMethod2");
    }

    @Override
    public void invokeMethod3() {
        System.out.println("call invokeMethod3");
    }

    @Override
    public void invokeMethod4() {
        System.out.println("call invokeMethod4");
    }
}
