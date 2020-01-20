package com.example.mybatis3.dao;


import com.example.mybatis3.pojo.User;
import org.springframework.stereotype.Repository;


public interface MyBatisUserDao {
	public User getUser(Long id);
}