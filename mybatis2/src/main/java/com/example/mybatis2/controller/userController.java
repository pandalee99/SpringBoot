package com.example.mybatis2.controller;

import com.example.mybatis2.pojo.User;
import com.example.mybatis2.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private userService user;

    @RequestMapping("/find")
    public User find(int id ){

        return user.find(id);
    }
}
