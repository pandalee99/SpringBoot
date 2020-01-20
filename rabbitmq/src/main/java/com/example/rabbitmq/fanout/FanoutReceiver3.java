package com.example.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.3")
public class FanoutReceiver3 {


    @RabbitHandler
    public void process(String message){

        System.out.println("Receiver form fanout_3: "+message);

    }

}
