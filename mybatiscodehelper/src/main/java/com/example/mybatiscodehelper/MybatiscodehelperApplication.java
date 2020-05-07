package com.example.mybatiscodehelper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mybatiscodehelper.mapper")
public class MybatiscodehelperApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatiscodehelperApplication.class, args);
    }

}
