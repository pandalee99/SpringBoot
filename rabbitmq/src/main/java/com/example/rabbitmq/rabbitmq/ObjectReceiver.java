package com.example.rabbitmq.rabbitmq;


import com.example.rabbitmq.pojo.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "object_queue")
public class ObjectReceiver {

    @RabbitHandler
    public void objectReceiver(User user){

        System.out.println("Receiver object:"+user.toString());

    }
}