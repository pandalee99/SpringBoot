package com.example.mybatiscodehelper.service;

import com.example.mybatiscodehelper.domain.UserMybatishelper;
public interface UserMybatishelperService{


    int deleteByPrimaryKey(Integer userid);

    int insert(UserMybatishelper record);

    int insertSelective(UserMybatishelper record);

    UserMybatishelper selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(UserMybatishelper record);

    int updateByPrimaryKey(UserMybatishelper record);

}
