package com.example.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.2")
public class FanoutReceiver2 {


    @RabbitHandler
    public void process(String message){

        System.out.println("Receiver form fanout_2: "+message);

    }

}
