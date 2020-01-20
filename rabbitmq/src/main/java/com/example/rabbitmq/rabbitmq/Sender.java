package com.example.rabbitmq.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String context = "hello----"+new Date();
        System.out.println("send:"+context);
        //往名称为 hello 的queue中发送消息
        this.amqpTemplate.convertAndSend("hello",context);
    }

    //给hello2发送消息,并接受一个计数参数
    public void send2(int i){
        String context = i+"";
        System.out.println(context+"--send:");
        this.amqpTemplate.convertAndSend("hello2",context);
    }



}
