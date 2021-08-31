package com.example.demo.service.impl;

import com.example.demo.service.GetFieldService;
import org.springframework.stereotype.Service;

import java.time.ZoneId;


@Service
public class GetFieldWithAOPServiceImpl implements GetFieldService {

    public String str = "GetFieldWithAOPServiceImpl_global_str";
    public final ZoneId zoneId = ZoneId.systemDefault();

    public GetFieldWithAOPServiceImpl() {
        System.out.println("GetFieldWithAOPServiceImpl: init...");
        System.out.println("GetFieldWithAOPServiceImpl: str = " + this.str);
        System.out.println("GetFieldWithAOPServiceImpl: zoneId = " + this.zoneId);
    }

    public String getStr() {
        return str;
    }

    public final String getFinalStr() {
        return str;
    }

    public ZoneId getZoneId() {
        return zoneId;
    }

    // public final method:
    public final ZoneId getFinalZoneId() {
        return zoneId;
    }
}
