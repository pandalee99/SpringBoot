package com.example.springmvc2.dao;


import com.example.springmvc2.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
	
	User getUser(Long id);

	List<User> findUsers(@Param("userName") String userName, @Param("note") String note);
	
	int insertUser(User user);
}
