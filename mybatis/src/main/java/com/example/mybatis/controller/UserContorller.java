package com.example.mybatis.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatis.pojo.User;
import com.example.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserContorller {

    @Autowired
    private UserService userService;

    // 增
    @PostMapping( value = "/insert")
    public Object insert( @RequestBody User user ) {
        return userService.insertUser( user );
    }

    // 改
    @PostMapping( value = "/update")
    public Object update( @RequestBody User user ) {
        return userService.updateUser( user );
    }

    // 删
    @PostMapping( value = "/delete")
    public Object delete( @RequestBody User user ) {
        return userService.deleteUser( user );
    }

    // 查
    @GetMapping( value = "/getUserByName")
    public Object getUserByName( @RequestParam String userName ) {
        return userService.findUserByName( userName );
    }

    @GetMapping( value = "/page")
    public Object getUserPage(Page page, User user ) {
        return userService.getUserPage( page, user );
    }
}