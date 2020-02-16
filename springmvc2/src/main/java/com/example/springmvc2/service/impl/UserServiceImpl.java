package com.example.springmvc2.service.impl;


import com.example.springmvc2.dao.UserDao;
import com.example.springmvc2.pojo.User;
import com.example.springmvc2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao = null;
	
	@Override
	public User getUser(Long id) {
		return userDao.getUser(id);
	}

	@Override
	public List<User> findUsers(String userName, String note) {
		return userDao.findUsers(userName, note);
	}

	@Override
	public int insertUser(User user) {
		return userDao.insertUser(user);
	}
	
}
