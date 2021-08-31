package com.example.demo.service.impl;

import com.example.demo.service.GetFieldService;
import org.springframework.stereotype.Service;

import java.time.ZoneId;


@Service
public class GetFieldServiceImpl implements GetFieldService {

    public String str = "GetFieldServiceImpl_global_str";
    public final ZoneId zoneId = ZoneId.systemDefault();

    public GetFieldServiceImpl() {
        System.out.println("GetFieldServiceImpl: init...");
        System.out.println("GetFieldServiceImpl: str = " + this.str);
        System.out.println("GetFieldServiceImpl: zoneId = " + this.zoneId);
    }

    public String getStr() {
        return str;
    }

    public final String getFinalStr() {
        return str;
    }

    // public方法:
    public ZoneId getZoneId() {
        return zoneId;
    }

    // public final方法:
    public final ZoneId getFinalZoneId() {
        return zoneId;
    }
}
