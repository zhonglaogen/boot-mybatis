package com.example.boot1cache.controller;

import com.example.boot1cache.entity.Admin;
import com.example.boot1cache.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
    AdminMapper adminMapper;


    @GetMapping("/getadmin/{id}")
    public Admin getAdmin(@PathVariable("id") Integer id){
      return   adminMapper.getUserById(id);
    }
}
