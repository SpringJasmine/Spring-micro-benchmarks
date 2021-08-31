package com.example.demo.controller;

import com.example.demo.model.AopXmlTestBean;
import com.example.demo.model.Student;
import com.example.demo.model.XmlDIServiceProvider;
import com.example.demo.service.SingletonDIServiceA;
import com.example.demo.service.SingletonDIServiceB;
import com.example.demo.tag.SingletonDITag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description SingletonDIController
 */
@RestController
@RequestMapping(value = "/singletonDI")
public class SingletonDIController {
    @SingletonDITag(description = "Singleton mode + use type for injection")
    @Autowired
    private SingletonDIServiceA singletonDIServiceA_1;
    @Autowired
    private SingletonDIServiceA singletonDIServiceA_2;

    @SingletonDITag(description = "Singleton mode + use name for injection")
    @Autowired
    @Qualifier("singletonDIServiceB_1")
    private SingletonDIServiceB singletonDIServiceBName_1_1;
    @Autowired
    @Qualifier("singletonDIServiceB_1")
    private SingletonDIServiceB singletonDIServiceBName_1_2;
    @Autowired
    @Qualifier("singletonDIServiceB_2")
    private SingletonDIServiceB singletonDIServiceBName_2_1;

    @SingletonDITag(description = "Singleton mode + method @Bean for injection")
    @Autowired
    @Qualifier("student")
    private Student student1;
    @Autowired
    @Qualifier("student")
    private Student student2;

    @SingletonDITag(description = "Singleton mode + use construction method for injection + methods of this class are processed by AOP")
    @Autowired
    private AopXmlTestBean aopXmlTestBean1;
    @Autowired
    private AopXmlTestBean aopXmlTestBean2;

    @SingletonDITag(description = "Singleton mode + use setter method injection")
    @Autowired
    private XmlDIServiceProvider xmlDIServiceProvider1;
    @Autowired
    private XmlDIServiceProvider xmlDIServiceProvider2;

    //Dependency injection: singleton mode + use type for injection
    @SingletonDITag(description = "Determine whether the singletons are the same")
    @RequestMapping("/singleton1")
    public void singleton1() {
        singletonDIServiceA_1.print();
        singletonDIServiceA_2.print();
        System.out.println(singletonDIServiceA_1 == singletonDIServiceA_2);//true
    }

    //Dependency injection: singleton mode + use name for injection
    @SingletonDITag(description = "Determine whether the singletons are the same")
    @RequestMapping("/singleton2")
    public void singleton2() {
        singletonDIServiceBName_1_1.print();
        singletonDIServiceBName_1_2.print();
        System.out.println(singletonDIServiceBName_1_1 == singletonDIServiceBName_1_2);//true  //Because it is a singleton mode
    }

    //Dependency injection: singleton mode + use name for injection
    @SingletonDITag(description = "Determine whether the singletons are the same")
    @RequestMapping("/singleton3")
    public void singleton3() {
        singletonDIServiceBName_1_1.print();
        singletonDIServiceBName_2_1.print();
        System.out.println(singletonDIServiceBName_1_1 == singletonDIServiceBName_2_1);//false  //Because @Qualifier is used to inject different objects by name.
    }

    //Dependency injection: singleton mode + method @Bean for injection
    @SingletonDITag(description = "Determine whether the singletons are the same")
    @RequestMapping("/singleton4")
    public void singleton4() {
        System.out.println("student1 = " + student1);
        System.out.println("student2 = " + student2);
        System.out.println(student1 == student2);//true  //Because of the singleton pattern
    }

    /**
     * Test the method of constructing method injection.
     */
    @SingletonDITag(description = "Determine whether the singletons are the same")
    @RequestMapping(value = "/singleton5")
    public void singleton5() {
        System.out.println("aopXmlTestBean1 = " + aopXmlTestBean1);
        System.out.println("aopXmlTestBean2 = " + aopXmlTestBean2);
        System.out.println(aopXmlTestBean1 == aopXmlTestBean2);
    }

    /**
     * Test setter method injection
     */
    @SingletonDITag(description = "Determine whether the singletons are the same")
    @RequestMapping(value = "/singleton6")
    public void singleton6() {
        xmlDIServiceProvider1.getXmlDIService().xmlDITest();
        System.out.println("xmlDIServiceProvider1 = " + xmlDIServiceProvider1);
        System.out.println("xmlDIServiceProvider2 = " + xmlDIServiceProvider2);
        System.out.println(xmlDIServiceProvider1 == xmlDIServiceProvider2);
    }
}
