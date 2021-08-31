package com.example.demo.controller;

import com.example.demo.model.AopXmlTestBean;
import com.example.demo.service.AOPService;
import com.example.demo.tag.AOPCheckTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description AOPController
 */
@RestController
@RequestMapping(value = "/aopTest")
public class AOPController {

    @Autowired
    private AOPService aopService;
    @Autowired
    private AopXmlTestBean aopXmlTestBean;

    @AOPCheckTag(description = "Perform AOP processing on the interface method, which has no return parameters")
    @RequestMapping(value = "/aop1", method = RequestMethod.GET)
    public void aop1() {
        aopService.testAOPAnno1();
    }

    @AOPCheckTag(description = "AOP processing of interface methods + AOP processing of specific methods, and return parameters")
    @RequestMapping(value = "/aop2", method = RequestMethod.GET)
    public void aop2(HttpServletRequest request) {
        String token = request.getParameter("token");
        System.out.println("AOPController.aop2 get return Value: " + aopService.testAOPAnno2(token));
    }

    @AOPCheckTag(description = "Use interface to implement AOP")
    @RequestMapping(value = "/aop3", method = RequestMethod.GET)
    public void aop3() {
        aopService.testAOPAPI3();
    }

    @AOPCheckTag(description = "Configure AOP using XML")
    @RequestMapping(value = "/aop4")
    public void aop4() {
        aopXmlTestBean.doSomething();
    }
}
