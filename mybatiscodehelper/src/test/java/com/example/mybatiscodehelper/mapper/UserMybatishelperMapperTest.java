package com.example.mybatiscodehelper.mapper;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileNotFoundException;

public class UserMybatishelperMapperTest {
    private static UserMybatishelperMapper mapper;

    @org.junit.BeforeClass
    public static void setUpMybatisDatabase() {
        SqlSessionFactory builder = new SqlSessionFactoryBuilder().build(UserMybatishelperMapperTest.class.getClassLoader().getResourceAsStream("mybatisTestConfiguration/UserMybatishelperMapperTestConfiguration.xml"));
        //you can use builder.openSession(false) to not commit to database
        mapper = builder.getConfiguration().getMapper(UserMybatishelperMapper.class, builder.openSession(true));
    }

    @org.junit.Test
    public void testFindByUsernameAndUserid() throws FileNotFoundException {
        mapper.findByUsernameAndUserid("Jack",1);

    }
}
