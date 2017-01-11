package com.wangdh.learner.redis;

import redis.clients.jedis.Jedis;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Jedis jedis = new Jedis("127.0.0.1");
    	String key = "name";
    	
    	// 设置key-value
    	// 没有新增，有更新
    	jedis.set(key, "wangdh");
    	
    	// 根据key获取value
    	System.out.println(jedis.get(key));
    	
    	// 根据key删除value
    	jedis.del(key);
    	
    	// 释放连接
    	jedis.close();
        System.out.println( "OK!" );
    }
}
