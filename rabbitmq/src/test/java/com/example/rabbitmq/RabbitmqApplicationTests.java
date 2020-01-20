package com.example.rabbitmq;

import com.example.rabbitmq.fanout.FanoutSender;
import com.example.rabbitmq.pojo.User;
import com.example.rabbitmq.rabbitmq.ObjectSender;
import com.example.rabbitmq.rabbitmq.Sender;
import com.example.rabbitmq.rabbitmq.Sender2;
import com.example.rabbitmq.topic.TopicSender;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class RabbitmqApplicationTests {
    @Autowired
    Sender Sender;

    @Autowired
    Sender2 Sender2;

    @Autowired
    ObjectSender objectSender;

    @Autowired
    TopicSender topicSender;

    @Autowired
    FanoutSender fanoutSender;

    @Test
    public void contextLoads() {
        Sender.send();
    }

    @Test
    public void manyReceiver(){
        for (int i=0;i<10;i++){
            Sender.send2(i);
        }
    }

    @Test
    public void many2many(){
        for (int i=0;i<10;i++){
            Sender.send2(i);
            Sender2.send2(i);
        }
    }
    @Test
    public void object(){
        User user=new User();
        user.setUsername("张三");
        user.setPassword("123456");
        objectSender.sendUser(user);
    }

    @Test
    public void topic(){
        topicSender.send1();
        topicSender.send2();
    }

    @Test
    public void fanout(){
        fanoutSender.send();
    }
}
