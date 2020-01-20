package com.example.mybatis3;

import com.example.mybatis3.dao.MyBatisUserDao;
import com.example.mybatis3.enumeration.SexEnum;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.example.mybatis3.dao")
public class Mybatis3Application {

    public static void main(String[] args) {
        SpringApplication.run(Mybatis3Application.class, args);
    }



    @Autowired
    private SqlSessionFactory sqlSessionFactory = null;

	// 定义一个MyBatis的Mapper接口
	@Bean
	public MapperFactoryBean<MyBatisUserDao> initMyBatisUserDao() {
	     MapperFactoryBean<MyBatisUserDao> bean = new MapperFactoryBean<>();
	     bean.setMapperInterface(MyBatisUserDao.class);
	     bean.setSqlSessionFactory(sqlSessionFactory);
	     TypeHandler<SexEnum> sexTypeHandler = sqlSessionFactory.getConfiguration().getTypeHandlerRegistry().getTypeHandler(SexEnum.class);
	     return bean;
	}
}
