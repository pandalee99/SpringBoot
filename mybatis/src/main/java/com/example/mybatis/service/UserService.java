package com.example.mybatis.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatis.pojo.User;

public interface UserService extends IService<User> {
    int insertUser( User user );
    int updateUser( User user );
    int deleteUser( User user );
    User findUserByName( String userName );
    IPage getUserPage(Page page, User user );


}
