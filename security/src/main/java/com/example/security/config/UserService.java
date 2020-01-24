package com.example.security.config;

import com.example.security.dao.UserMapper;
import com.example.security.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
     UserMapper userMapper;

    public User getUserName(String name) {
        return userMapper.getUser(name);
    }
}
