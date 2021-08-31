package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.annotation.Permission;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.PermissionService;
import com.example.demo.tag.HasPermissionTag;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;


@Service
public class PermissionServiceImpl extends ServiceImpl<UserMapper, User> implements PermissionService {

    @HasPermissionTag(description = "")
    @Override
    public void accessSuccess(String auth) {
        System.out.println("accessSuccess()  Call directly through this");
        permissionAdmin(auth);//AOP will not take effect here (this is called directly)
        permissionUser(auth);//AOP will not take effect here (this is called directly)
    }

    @Override
    public void accessFail(String auth) {
        System.out.println("accessFail()  Called by proxy object");
        ((PermissionServiceImpl) AopContext.currentProxy()).permissionAdmin(auth);//Here AOP takes effect (call through proxy object)
        ((PermissionServiceImpl) AopContext.currentProxy()).permissionUser(auth);//Here AOP takes effect (call through proxy object)
    }

    //Example of verification failure
    @Permission(auth = "admin")//All verification failed
    public void permissionAdmin(String auth) {
        System.out.println("permissionInvalid()，admin access。");
    }

    //Example of successful verification
    @Permission//All verified successfully
    public void permissionUser(String auth) {
        System.out.println("permissionValid()，user access。");
    }

}
