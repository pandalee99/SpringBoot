package com.example.guavacache.controller;

import com.example.guavacache.pojo.User;
import com.example.guavacache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    CacheManager cacheManager;

    @RequestMapping( value = "/getusersbyname", method = RequestMethod.POST)
    public List<User> geUsersByName(@RequestBody User user ) {
        System.out.println( "-------------------------------------------" );
        System.out.println("call /getusersbyname");
        System.out.println(cacheManager.toString());
        List<User> users = userService.getUsersByName( user.getUserName() );
        return users;
    }
}
