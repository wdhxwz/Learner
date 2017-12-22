package com.wangdh.learner.redis.Spring.data;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.hash.HashMapper;
import org.springframework.data.redis.hash.Jackson2HashMapper;
import org.springframework.data.redis.hash.ObjectHashMapper;

import java.util.Map;

/**
 * @author wangdh
 * @Description
 * @date 2017-12-22
 */
public class HashMappingTestApp {

    public static void  main(String[] agrs){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-redis-simpleConfig.xml");
        RedisTemplate redisTemplate = context.getBean(RedisTemplate.class);

        HashOperations<String, String, Object> hashOperations = redisTemplate.opsForHash();
        HashMapper<Object, String, Object> mapper = new Jackson2HashMapper(false);

        String key = "person2";
        Person person = new Person();
        person.setFirstname("王");
        person.setLastname("东鸿");

        Address address = new Address();
        address.setCountry("中国");
        address.setCity("广州");

        person.setAddress(address);

        Map<String, Object> mappedHash = mapper.toHash(person);
        hashOperations.putAll(key, mappedHash);

        Map<String, Object> loadedHash = hashOperations.entries(key);

        Person newPerson = (Person) mapper.fromHash(loadedHash);
        System.out.println(newPerson.toString());
    }
}
