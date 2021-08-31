package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.model.User;


public interface PermissionService extends IService<User> {
    void accessSuccess(String auth);

    void accessFail(String auth);

    void permissionUser(String auth);

    void permissionAdmin(String auth);
}
