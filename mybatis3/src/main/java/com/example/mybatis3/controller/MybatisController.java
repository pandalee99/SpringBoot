package com.example.mybatis3.controller;

import com.example.mybatis3.pojo.User;
import com.example.mybatis3.service.MyBatisUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class MybatisController {

    @Autowired
    private MyBatisUserService myBatisUserService=null;

    @RequestMapping("/get")
    public User getUser(Long id){
        return myBatisUserService.getUser(id);
    }
}
