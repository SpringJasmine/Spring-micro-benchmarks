package com.example.demo.service.impl;


import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.SSMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SSMServiceImpl implements SSMService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void saveUser(String uname, String password, String id, Integer age) {
        User user = new User(id, uname, age, password);
        int idOldInt = Integer.parseInt(userMapper.selectLastId(Integer.parseInt(id)).getId());
        user.setId(String.valueOf(idOldInt + 1));
        userMapper.insert(user);
    }
}
