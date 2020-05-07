package com.example.mybatiscodehelper.mapper;

import com.example.mybatiscodehelper.domain.UserMybatishelper;import org.apache.ibatis.annotations.Param;import java.util.Date;import java.util.List;

public interface UserMybatishelperMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(UserMybatishelper record);

    int insertSelective(UserMybatishelper record);

    UserMybatishelper selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(UserMybatishelper record);

    int updateByPrimaryKey(UserMybatishelper record);

    List<UserMybatishelper> findByUsernameAndUserid(@Param("username") String username, @Param("userid") Integer userid);

    List<UserMybatishelper> findByUsernameAndUsernameBetween(@Param("username") String username, @Param("minUsername") String minUsername, @Param("maxUsername") String maxUsername);

    UserMybatishelper findFirstByUseridAndUsernameBetweenOrderBySalaryDescAndUseridDesc(@Param("userid") Integer userid, @Param("minUsername") String minUsername, @Param("maxUsername") String maxUsername);

    int updateBirthByUseridAndUsername(@Param("updatedBirth") Date updatedBirth, @Param("userid") Integer userid, @Param("username") String username);

    int deleteByUsernameAndUserid(@Param("username") String username, @Param("userid") Integer userid);


}