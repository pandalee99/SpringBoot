package com.example.guavacache.mapper;

import com.example.guavacache.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> getUsers();
    int addUser(User user);
    List<User> getUsersByName(String userName );
}
