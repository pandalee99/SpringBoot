package com.example.springmvc2.service;


import com.example.springmvc2.pojo.User;

import java.util.List;

public interface UserService {
	
	User getUser(Long id);

	List<User> findUsers(String userName, String note);
	
	int insertUser(User user);

}
