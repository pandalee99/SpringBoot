package com.example.mybatiscodehelper;

import com.example.mybatiscodehelper.domain.UserMybatishelper;
import com.example.mybatiscodehelper.mapper.UserMybatishelperMapper;
import com.example.mybatiscodehelper.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatiscodehelperApplicationTests {

    @Autowired
    UserMybatishelperMapper userMybatishelperMapper;


    @Test
    void contextLoads() {
        UserMybatishelper user=new UserMybatishelper();
       user=userMybatishelperMapper.selectByPrimaryKey(1);
        System.out.println(user.getUsername());

    }

}
