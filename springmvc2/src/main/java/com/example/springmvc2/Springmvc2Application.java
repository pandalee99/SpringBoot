package com.example.springmvc2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.springmvc2.dao")
public class Springmvc2Application{

    public static void main(String[] args) {
        SpringApplication.run(Springmvc2Application.class, args);
    }

}
