package com.example.mybatis3.service;

import com.example.mybatis3.dao.MyBatisUserDao;
import com.example.mybatis3.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyBatisUserServiceImpl implements MyBatisUserService {

    @Autowired
    private MyBatisUserDao myBatisUserDao=null;

    @Override
    public User getUser(Long id) {
        return myBatisUserDao.getUser(id);
    }
}
