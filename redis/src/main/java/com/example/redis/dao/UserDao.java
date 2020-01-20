package com.example.redis.dao;

import com.example.redis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    User getUser(Long id);

    int insertUser(User user);

    int updateUser(User user);

    List<User> findUsers(@Param("userName") String userName,@Param("note") String note);

    int deleteUser(Long id);
}
