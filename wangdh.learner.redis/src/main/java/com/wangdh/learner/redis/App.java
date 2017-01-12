package com.wangdh.learner.redis;

import redis.clients.jedis.Jedis;

/**
 * Hello world!
 *
 * http://blog.csdn.net/column/details/jedislearning.html
 */
public class App 
{
    public static void main( String[] args )
    {
    	int dbIndex=2;
    	Jedis jedis = new Jedis("127.0.0.1");
    	jedis.auth("admin");

    	// 选择db
    	jedis.select(dbIndex);
    	
    	jedis.auth("admin");
    	String key = "name";
    	
    	// 设置key-value
    	// 没有新增，有更新
    	jedis.set(key, "wangdh");
    	
    	// 根据key获取value
    	System.out.println(jedis.get(key));
    	
    	// 根据key删除value
    	// jedis.del(key);
    	
    	// 释放连接
    	jedis.close();
        System.out.println( "OK!" );
    }
}
