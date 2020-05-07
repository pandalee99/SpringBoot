package com.example.redis2;

import com.example.redis2.config.RedisConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

@SpringBootTest
class Redis2ApplicationTests {

    @Test
    void contextLoads() {
        ApplicationContext context=new AnnotationConfigApplicationContext(RedisConfig.class);
        RedisTemplate redisTemplate=context.getBean(RedisTemplate.class);
        redisTemplate.opsForValue().set("ket1","value1");
        redisTemplate.opsForHash().put("hash","field","hvalue");

//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(RedisConfig.class);
//        RedisTemplate redisTemplate = ctx.getBean(RedisTemplate.class);
////		redisTemplate.opsForValue().set("key1", "value1");
////		redisTemplate.opsForHash().put("hash", "field", "hvalue");
//        useSessionCallback(redisTemplate);
////		useRedisCallback(redisTemplate);
//        ctx.close();
    }

    @Test
    void contextLoads2(){
                AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(RedisConfig.class);
        RedisTemplate redisTemplate = ctx.getBean(RedisTemplate.class);
//		redisTemplate.opsForValue().set("key1", "value1");
//		redisTemplate.opsForHash().put("hash", "field", "hvalue");
        useSessionCallback(redisTemplate);
//		useRedisCallback(redisTemplate);
        ctx.close();
    }

//    //	// 需要处理底层的转换规则，如果不考虑改写底层，尽量不使用它
//	public static void useRedisCallback(RedisTemplate redisTemplate) {
//	    redisTemplate.execute(new RedisCallback() {
//	        @Override
//	        public Object doInRedis(RedisConnection rc)
//	                throws DataAccessException {
//	            rc.set("key1".getBytes(), "value1".getBytes());
//	            rc.hSet("hash".getBytes(), "field".getBytes(), "hvalue".getBytes());
//	            return null;
//	        }
//	    });
//	}
//
//    //	// 高级接口，比较友好，一般情况下，优先使用它
//	public static void useSessionCallback(RedisTemplate redisTemplate) {
//	    redisTemplate.execute(new SessionCallback() {
//	        @Override
//	        public Object execute(RedisOperations ro)
//	                throws DataAccessException {
//	            ro.opsForValue().set("key1", "value1");
//	            ro.opsForHash().put("hash", "field", "hvalue");
//	            return null;
//	        }
//	    });
//	}

    public static void useRedisCallback(RedisTemplate redisTemplate) {
        redisTemplate.execute((RedisConnection rc) -> {
            rc.set("key1".getBytes(), "value1".getBytes());
            rc.hSet("hash".getBytes(), "field".getBytes(), "hvalue".getBytes());
            return null;
        });
    }

    public static void useSessionCallback(RedisTemplate redisTemplate) {
        redisTemplate.execute((RedisOperations ro) -> {
            ro.opsForValue().set("key1", "value1");
            ro.opsForHash().put("hash", "field", "hvalue");
            return null;
        });
    }

}
