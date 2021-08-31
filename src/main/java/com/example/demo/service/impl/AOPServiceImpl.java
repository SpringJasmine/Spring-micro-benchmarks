package com.example.demo.service.impl;

import com.example.demo.service.AOPService;
import org.springframework.stereotype.Service;


@Service
public class AOPServiceImpl implements AOPService {
    @Override
    public void testAOPAnno1() {
        System.out.println("testAOP1 do something");
    }

    @Override
    public String testAOPAnno2(String parameter) {
        System.out.println("testAOP2 get parameter: " + parameter);
        return parameter;
    }

    @Override
    public void testAOPAPI3() {
        System.out.println("testAOP3 do something");
    }
}
