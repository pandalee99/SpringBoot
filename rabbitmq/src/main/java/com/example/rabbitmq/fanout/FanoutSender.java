package com.example.rabbitmq.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {

    @Autowired
    AmqpTemplate amqpTemplate;


    public void send(){

        String context = "hi, fanout msg ";
        System.out.println("Sender : " + context);
        //这里使用了1、2、3三个队列绑定到Fanout交换机上面，发送端的routing_key写任何字符都会被忽略：
        amqpTemplate.convertAndSend("fanoutExchange","", context);

    }

}
