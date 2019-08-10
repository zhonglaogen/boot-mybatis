package com.zlx.bootmybatis.controller;

import com.zlx.bootmybatis.entity.User;
import com.zlx.bootmybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return userMapper.getUserById(id);
    }

    @GetMapping("/user/{id}/{name}")
    public User insertUser(User user){
        userMapper.insertUser(user);
        return user;
    }
}
