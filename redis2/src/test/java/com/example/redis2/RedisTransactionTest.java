package com.example.redis2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

@SpringBootTest
public class RedisTransactionTest {

    @Autowired
    RedisTemplate redisTemplate=null;

    @Autowired
    StringRedisTemplate stringRedisTemplate=null;

    @Test
    void test1(){

        redisTemplate.opsForValue().set("key1","value1");
        List list = (List) redisTemplate.execute((RedisOperations operations) -> {
            // 设置要监控key1
            operations.watch("key1");
            // 开启事务，在exec命令执行前，全部都只是进入队列
            operations.multi();
            operations.opsForValue().set("key2", "value2");
            operations.opsForValue().increment("key1", 1);// ①
            // 获取值将为null，因为redis只是把命令放入队列，
            Object value2 = operations.opsForValue().get("key2");
            System.out.println("命令在队列，所以value为null【" + value2 + "】");
            operations.opsForValue().set("key3", "value3");
            Object value3 = operations.opsForValue().get("key3");
            System.out.println("命令在队列，所以value为null【" + value3 + "】");
            // 执行exec命令，将先判别key1是否在监控后被修改过，如果是不执行事务，否则执行事务
            return operations.exec();// ②
        });
        System.out.println(list);
    }

    @Test
    void test2(){
        Long start = System.currentTimeMillis();
        List list = (List) redisTemplate.executePipelined((RedisOperations operations) -> {
            for (int i = 1; i <= 100000; i++) {
                operations.opsForValue().set("pipeline_" + i, "value_" + i);
                String value = (String) operations.opsForValue().get("pipeline_" + i);
                if (i == 100000) {
                    System.out.println("命令只是进入队列，所以值为空【" + value + "】");
                }
            }
            return null;
        });
        Long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "毫秒。");
    }
}
