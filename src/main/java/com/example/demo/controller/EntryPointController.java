package com.example.demo.controller;

import com.example.demo.service.EntryPointService;
import com.example.demo.tag.EntryPointTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description EntryPointController
 */
@RestController
@RequestMapping(value = "/entryPoint")
public class EntryPointController {
    @Autowired
    private EntryPointService entryPointService;

    //Entry point: annotation method
    @EntryPointTag(description = "public methods and do not use AOP")
    @RequestMapping("/entryPoint1")
    public void entryPoint1() {
        System.out.println("entryPoint1");
        entryPointService.invokeMethod1();
    }

    //Entry point: private method
    @EntryPointTag(description = "Private methods and do not use AOP")
    @RequestMapping("/entryPoint2")
    private void entryPoint2() {
        System.out.println("entryPoint2");
        entryPointService.invokeMethod2();
    }

    public void FakeEntryPoint1() {
        System.out.println("FakeEntryPoint1");
    }

    private void FakeEntryPoint2() {
        System.out.println("FakeEntryPoint2");
    }
}
