package com.example.boot1cache.controller;

import com.example.boot1cache.entity.User;
import com.example.boot1cache.mapper.UserMapper;
import com.example.boot1cache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/getuser/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return userService.getUser(id);
    }
}
