package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.*;
import com.example.demo.tag.PrototypeDITag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description PrototypeDIController
 */
@RestController
@RequestMapping(value = "/prototypeDI")
public class PrototypeDIController {
    @PrototypeDITag(description = "Prototype mode + annotation")
    @Autowired
    private PrototypeDIServiceC prototypeDIServiceC_1;
    @Autowired
    private PrototypeDIServiceC prototypeDIServiceC_2;

    @PrototypeDITag(description = "Prototype mode + use name for injection")
    @Autowired
    @Qualifier("prototypeDIServiceD_1")
    private PrototypeDIServiceD prototypeDIServiceDName_1_1;
    @Autowired
    @Qualifier("prototypeDIServiceD_1")
    private PrototypeDIServiceD prototypeDIServiceDName_1_2;
    @Autowired
    @Qualifier("prototypeDIServiceD_2")
    private PrototypeDIServiceD prototypeDIServiceDName_2_1;

    @PrototypeDITag(description = "Prototype mode + method @Bean for injection")
    @Autowired
    @Qualifier("student_prototype")
    private Student student_prototype1;
    @Autowired
    @Qualifier("student_prototype")
    private Student student_prototype2;

    @PrototypeDITag(description = "Determine whether the prototypes are the same")
    //Dependency injection: prototype mode + annotation
    @RequestMapping("/prototype1")
    public void prototype1() {
        prototypeDIServiceC_1.print();
        prototypeDIServiceC_2.print();
        System.out.println(prototypeDIServiceC_1 == prototypeDIServiceC_2);
    }

    @PrototypeDITag(description = "Determine whether the prototypes are the same")
    //Dependency injection: prototype mode + use name for injection
    @RequestMapping("/prototype2")
    public void prototype2() {
        prototypeDIServiceDName_1_1.print();
        prototypeDIServiceDName_1_2.print();
        System.out.println(prototypeDIServiceDName_1_1 == prototypeDIServiceDName_1_2);//false
    }

    @PrototypeDITag(description = "Determine whether the prototypes are the same")
    //Dependency injection: prototype mode + use name for injection
    @RequestMapping("/prototype3")
    public void prototype3() {
        prototypeDIServiceDName_1_1.print();
        prototypeDIServiceDName_2_1.print();
        System.out.println(prototypeDIServiceDName_1_1 == prototypeDIServiceDName_2_1);//false  //Dependency injection: prototype mode + use name for injection
    }

    @PrototypeDITag(description = "Determine whether the prototypes are the same")
    //Dependency injection: prototype mode + method @Bean for injection
    @RequestMapping("/prototype4")
    public void prototype4() {
        System.out.println("student_prototype1 = " + student_prototype1);
        System.out.println("student_prototype2 = " + student_prototype2);
        System.out.println(student_prototype1 == student_prototype2);//false
    }
}
