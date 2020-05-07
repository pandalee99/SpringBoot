package com.example.redis2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.core.*;

import redis.clients.jedis.Jedis;

import java.util.*;

@SpringBootTest
public class RedisTest2 {

    @Autowired
    RedisTemplate redisTemplate=null;

    @Autowired
    StringRedisTemplate stringRedisTemplate=null;

    @Test
    void  test(){

        redisTemplate.opsForValue().set("key1","value1");

        redisTemplate.opsForValue().set("int_key","1");
        stringRedisTemplate.opsForValue().set("int","1");
        //使用运算
        stringRedisTemplate.opsForValue().increment("int",1);
        //获取底层jedis连接
        Jedis jedis=(Jedis)stringRedisTemplate.getConnectionFactory()
                .getConnection().getNativeConnection();
        //减一操作，这个命令需要获得底层连接才能操作
        jedis.decr("int");

        Map<String,String> hash=new HashMap<>();
        hash.put("field1","value1");
        hash.put("field2","value2");
        //存入一个散列数据类型
        stringRedisTemplate.opsForHash().putAll("hash",hash);

        //新增一个字段
        stringRedisTemplate.opsForHash().put("hash","field3","value3");
        //绑定散列操作的Key，这样可以连续对同一个散列数据类型进行操作
        BoundHashOperations hashOperations=stringRedisTemplate.boundHashOps("hash");
        //删除两个字段
        hashOperations.delete("field1","field2");
        //新增一个字段
        hashOperations.put("field4","value4");
    }

    @Test
    void test2(){
        //插入两个列表
        //链表从左到右顺序为：v10、v8、v6...
        stringRedisTemplate.opsForList().leftPushAll("List1","v2","v4","v6","v8","v10");

        //链表从右到左顺序为：v1,v2,v3...
        stringRedisTemplate.opsForList().rightPushAll("List2","v1","v2","v3","v4","v5","v6");

        //绑定链表操作
        BoundListOperations listOperations=stringRedisTemplate.boundListOps("List2");
        //从右边弹出一个成员
        Object result1=listOperations.rightPop();
        //获取定位元素，从下标0开始算，这里为v2
        Object result2=listOperations.index(1);
        //从左边插入链表
        listOperations.leftPush("v0");
        //求链表长度
        Long size=listOperations.size();
        //求链表下标区间成员，整个链表下标范围为0，到size-1，这里不取最后一个元素
        List elements=listOperations.range(0,size-2);
        for (Object a:elements) {
            System.out.println(a.toString());
        }
    }

    @Test
    void test3(){
        //重复两次v1，因为集合不允许重复，所以结果还是5个值
        stringRedisTemplate.opsForSet().add("set1","v1","v1","v2","v3","v4","v5");
        stringRedisTemplate.opsForSet().add("set2","v2","v4","v6","v8");
        //绑定集合
        BoundSetOperations setOperations=stringRedisTemplate.boundSetOps("set1");
        //增加两个元素
        setOperations.add("v6","v7");
        //删除
        setOperations.remove("v1","v7");
        //返回所有元素
        Set set=setOperations.members();
        //求成员数量
        Long size=setOperations.size();

        //求交集
        setOperations.intersectAndStore("set2","inter");
        //求差集
        setOperations.diff("set2");
        //求差集并保存
        setOperations.diffAndStore("set2","diff");
        //求并集
        Set union=setOperations.union("set2");
        //求并集并保存
        setOperations.unionAndStore("set2","union");

    }
    
    @Test
    void test4(){
        Set<ZSetOperations.TypedTuple<String>> typedTuples=new HashSet<>();
        for (int i = 1; i <=9 ; i++) {
            //分数
            double score=i*0.1;
            //创建一个TypedTuple对象，存入值和分数
            ZSetOperations.TypedTuple<String> typedTuple=
                    new DefaultTypedTuple<String>("value"+i,score);
            typedTuples.add(typedTuple);
        }

        //往有序集合插入元素
        stringRedisTemplate.opsForZSet().add("zset1",typedTuples);
        //绑定属性
        BoundZSetOperations<String ,String > zSetOperations=
                stringRedisTemplate.boundZSetOps("zset1");
        //增加一个元素
        zSetOperations.add("value10",0.26);
        Set<String > setRange=zSetOperations.range(1,6);
        Set<String > setScore=zSetOperations.rangeByScore(0.2,0.6);

        //定义值范围
        RedisZSetCommands.Range range=new RedisZSetCommands.Range();
        range.gt("value3");// 大于value3
        // range.gte("value3");// 大于等于value3
        // range.lt("value8");// 小于value8
        range.lte("value8");// 小于等于value8
        // 按值排序，请注意这个排序是按字符串排序
        Set<String> setLex = zSetOperations.rangeByLex(range);
        // 删除元素
        zSetOperations.remove("value9", "value2");
        // 求分数
        Double score = zSetOperations.score("value8");
        // 在下标区间下，按分数排序，同时返回value和score
        Set<ZSetOperations.TypedTuple<String>> rangeSet = zSetOperations.rangeWithScores(1, 6);
        // 在分数区间下，按分数排序，同时返回value和score
        Set<ZSetOperations.TypedTuple<String>> scoreSet = zSetOperations.rangeByScoreWithScores(1, 6);
        // 按从大到小排序
        Set<String> reverseSet = zSetOperations.reverseRange(2, 8);
    }
}
