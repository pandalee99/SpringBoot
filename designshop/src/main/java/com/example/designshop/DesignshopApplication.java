package com.example.designshop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.example.designshop.dao")
@EnableScheduling
public class DesignshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesignshopApplication.class, args);
    }

}
