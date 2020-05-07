package com.example.mybatiscodehelper.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.mybatiscodehelper.mapper.UserMybatishelperMapper;
import com.example.mybatiscodehelper.domain.UserMybatishelper;
import com.example.mybatiscodehelper.service.UserMybatishelperService;
@Service
public class UserMybatishelperServiceImpl implements UserMybatishelperService{

    @Resource
    private UserMybatishelperMapper userMybatishelperMapper;

    @Override
    public int deleteByPrimaryKey(Integer userid) {
        return userMybatishelperMapper.deleteByPrimaryKey(userid);
    }

    @Override
    public int insert(UserMybatishelper record) {
        return userMybatishelperMapper.insert(record);
    }

    @Override
    public int insertSelective(UserMybatishelper record) {
        return userMybatishelperMapper.insertSelective(record);
    }

    @Override
    public UserMybatishelper selectByPrimaryKey(Integer userid) {
        return userMybatishelperMapper.selectByPrimaryKey(userid);
    }

    @Override
    public int updateByPrimaryKeySelective(UserMybatishelper record) {
        return userMybatishelperMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserMybatishelper record) {
        return userMybatishelperMapper.updateByPrimaryKey(record);
    }

}
