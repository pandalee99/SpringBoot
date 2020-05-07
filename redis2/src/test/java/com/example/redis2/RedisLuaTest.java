package com.example.redis2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class RedisLuaTest {

    @Autowired
    RedisTemplate redisTemplate=null;

    @Autowired
    StringRedisTemplate stringRedisTemplate=null;

    @Test
    void test(){
        DefaultRedisScript<String> redisScript=new DefaultRedisScript<String >();
        //设置脚本
        redisScript.setScriptText("return 'i love you'");
        //定义返回类型
        redisScript.setResultType(String.class);
        RedisSerializer<String > redisSerializer=redisTemplate.getStringSerializer();

        //执行脚本
        String s=(String)redisTemplate.execute
                (redisScript,redisSerializer,redisSerializer,null);
        System.out.println();
    }

    @Test
    void test2(){
        String key1="this",key2="like";
        String value1="not",value2="yourself";


        String lua="redis.call('set',KEYS[1],ARGV[1]) \n"
                +"redis.call('set',KEYS[2],ARGV[2]) \n"
                +"local str1=redis.call('get',KEYS[1]) \n"
                +"local str2=redis.call('get',KEYS[2]) \n"
                +"if str1==str2 then \n"
                +"return 1 \n"
                +"end \n"
                +"return 0 \n";
        System.out.println(lua);

        //返回结果为Long
        DefaultRedisScript<Long> redisScript=new DefaultRedisScript<Long>();
        redisScript.setScriptText(lua);
        redisScript.setResultType(Long.class);
        //采用字符串序列化器
        RedisSerializer<String> stringRedisSerializer=redisTemplate.getStringSerializer();
        //定义key参数
        List<String> keyList =new ArrayList<>();
        keyList.add(key1);
        keyList.add(key2);
        //传递两个参数，第一个序列化器是key的序列化器
        //第二个是参数的序列化器
        Long result=(Long) redisTemplate.execute
                (redisScript,stringRedisSerializer,stringRedisSerializer,keyList,value1,value2);
    }
}
