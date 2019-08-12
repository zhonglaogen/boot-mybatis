package com.zlx.bootmybatis.controller;

import com.zlx.bootmybatis.entity.Admin;
import com.zlx.bootmybatis.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PathVariable搜集url的参数
 * @param是mybatis绑定参数的注解
 * @requestParam是controller绑定参数的注解
 */
@RestController
public class AdminController {

    @Autowired
    AdminMapper adminMapper;

    @GetMapping("/admin/{id}")
    public Admin getAdmin(@PathVariable("id") Integer id){
        Admin userById = adminMapper.getUserById(id);
        return userById;

    }


}
