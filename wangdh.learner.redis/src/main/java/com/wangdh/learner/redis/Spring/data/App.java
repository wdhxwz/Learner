package com.wangdh.learner.redis.Spring.data;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @author wangdh
 * @Description
 * @date 2017-12-21
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-redis-simpleConfig.xml");

        // 直接通过连接进行操作
        JedisConnectionFactory jedisConnectionFactory = context.getBean(JedisConnectionFactory.class);
        RedisConnection redisConnection = jedisConnectionFactory.getConnection();
        byte[] value = redisConnection.get("name".getBytes());
        System.out.println(new String(value));

        String ageKey = "age";
        redisConnection.set(ageKey.getBytes(), "26岁".getBytes());
        value = redisConnection.get(ageKey.getBytes());
        System.out.println(new String(value));

        RedisTemplate redisTemplate = context.getBean(RedisTemplate.class);
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("haha", "你好");

        // 消息发布
        String channel = "world";
        String message = "hello";

        redisConnection.publish(channel.getBytes(), message.getBytes());
        redisTemplate.convertAndSend("world",message);

        System.out.println(redisTemplate.getKeySerializer().getClass().getName());
        System.out.println(redisTemplate.getValueSerializer().getClass().getName());
        System.out.println(redisTemplate.getDefaultSerializer().getClass().getName());
        System.out.println(redisTemplate.getHashKeySerializer().getClass().getName());
        System.out.println(redisTemplate.getHashValueSerializer().getClass().getName());
    }
}
