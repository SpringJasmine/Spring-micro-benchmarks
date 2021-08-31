package com.example.demo.controller;

import com.example.demo.service.EntryPointService;
import com.example.demo.tag.EntryPointTag;
import com.example.demo.tag.NULLPointTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description EntryPointController
 */
@RestController
@RequestMapping(value = "/entryPointWithAOP")
public class EntryPointWithAOPController {
    @Autowired
    private EntryPointService entryPointService;

    //Entry point: annotation method
    @EntryPointTag(description = "public method and use AOP")
    @RequestMapping("/entryPoint3")
    public void entryPoint3() {
        System.out.println("entryPoint1");
        entryPointService.invokeMethod3();
    }

    //Entry point: private method
    @EntryPointTag(description = "Private method and use AOP")
    @NULLPointTag(description = "")
    @RequestMapping("/entryPoint4")
    private void entryPoint4() {
        System.out.println("entryPoint2");
        entryPointService.invokeMethod4();
    }

    public void FakeEntryPoint3() {
        System.out.println("FakeEntryPoint3");
    }

    private void FakeEntryPoint4() {
        System.out.println("FakeEntryPoint4");
    }
}
