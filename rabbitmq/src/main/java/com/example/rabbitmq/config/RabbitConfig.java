package com.example.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {

    //注意这里导入的队列是：
    //org.springframework.amqp.core.Queue;

    @Bean
    public Queue queue(){
         return new Queue("hello");
    }

    @Bean
    public Queue queue2(){
        return new Queue("hello2");
    }

    @Bean
    public Queue queue3(){
        return new Queue("object_queue");
    }
}
