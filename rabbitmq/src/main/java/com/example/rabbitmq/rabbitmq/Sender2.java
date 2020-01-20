package com.example.rabbitmq.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender2 {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send2(int i){
        String context = i+"";
        System.out.println(context+"--send:");
        this.amqpTemplate.convertAndSend("hello2",context);
    }
}
