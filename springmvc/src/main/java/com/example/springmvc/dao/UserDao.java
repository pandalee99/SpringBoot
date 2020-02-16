package com.example.springmvc.dao;


import com.example.springmvc.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
	
	User getUser(Long id);

	List<User> findUsers(@Param("userName") String userName, @Param("note") String note);
}
