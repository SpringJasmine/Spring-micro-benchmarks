package com.example.demo.controller;

import com.example.demo.service.impl.GetFieldWithAOPServiceImpl;
import com.example.demo.tag.NULLPointTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @Description GetFieldWithAOPController
 */
@RestController
@RequestMapping(value = "/getFieldWithAOP")
public class GetFieldWithAOPController {
    @Autowired
    private GetFieldWithAOPServiceImpl getFieldServiceWithAOPImpl;

    @RequestMapping("/getField7")
    public void getField1() {
        String str = getFieldServiceWithAOPImpl.str;
        System.out.println(str);
    }

    @RequestMapping("/getField8")
    public void getField2() {
        String str = getFieldServiceWithAOPImpl.getStr();
        System.out.println(str);
    }

    @RequestMapping("/getField9")
    public void getField3() {
        String str = getFieldServiceWithAOPImpl.getFinalStr();
        System.out.println(str);
    }

    @NULLPointTag(description = "")
    @RequestMapping("/getField10")
    public void getField4() {
        ZoneId zoneId = getFieldServiceWithAOPImpl.zoneId;
        String dt = ZonedDateTime.now(zoneId).toString();
        System.out.println(dt);
    }

    @RequestMapping("/getField11")
    public void getField5() {
        ZoneId zoneId = getFieldServiceWithAOPImpl.getZoneId();
        String dt = ZonedDateTime.now(zoneId).toString();
        System.out.println(dt);
    }

    @NULLPointTag(description = "")
    @RequestMapping("/getField12")
    public void getField6() {
        ZoneId zoneId = getFieldServiceWithAOPImpl.getFinalZoneId();
        String dt = ZonedDateTime.now(zoneId).toString();
        System.out.println(dt);
    }
}
