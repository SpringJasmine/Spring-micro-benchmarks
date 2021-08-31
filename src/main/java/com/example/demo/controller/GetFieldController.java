package com.example.demo.controller;

import com.example.demo.service.impl.GetFieldServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @Description GetFieldController
 */
@RestController
@RequestMapping(value = "/getField")
public class GetFieldController {
    @Autowired
    private GetFieldServiceImpl getFieldServiceImpl;

    @RequestMapping("/getField1")
    public void getField1() {
        String str = getFieldServiceImpl.str;
        System.out.println(str);
    }

    @RequestMapping("/getField2")
    public void getField2() {
        String str = getFieldServiceImpl.getStr();
        System.out.println(str);
    }

    @RequestMapping("/getField3")
    public void getField3() {
        String str = getFieldServiceImpl.getFinalStr();
        System.out.println(str);
    }

    @RequestMapping("/getField4")
    public void getField4() {
        ZoneId zoneId = getFieldServiceImpl.zoneId;
        String dt = ZonedDateTime.now(zoneId).toString();
        System.out.println(dt);
    }

    @RequestMapping("/getField5")
    public void getField5() {
        ZoneId zoneId = getFieldServiceImpl.getZoneId();
        String dt = ZonedDateTime.now(zoneId).toString();
        System.out.println(dt);
    }

    @RequestMapping("/getField6")
    public void getField6() {
        ZoneId zoneId = getFieldServiceImpl.getFinalZoneId();
        String dt = ZonedDateTime.now(zoneId).toString();
        System.out.println(dt);
    }
}
