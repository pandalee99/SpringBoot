package com.example.springmvc.service;


import com.example.springmvc.pojo.User;

import java.util.List;

public interface UserService {
	
	User getUser(Long id);

	List<User> findUsers(String userName, String note);

}
