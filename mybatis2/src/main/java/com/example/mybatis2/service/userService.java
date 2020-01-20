package com.example.mybatis2.service;

import com.example.mybatis2.mapper.userMapper;
import com.example.mybatis2.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService{

    @Autowired
    private userMapper user;

    public User find(int id) {
        return user.find(id);
    }
}
