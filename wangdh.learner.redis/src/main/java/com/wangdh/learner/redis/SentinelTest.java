package com.wangdh.learner.redis;

import java.util.HashSet;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

public class SentinelTest {

	public static void main(String[] args) {
		HashSet<String> sentinels = new HashSet<String>();
		sentinels.add("172.17.215.11:26379");
		sentinels.add("172.17.215.11:26380");
		
		// 创建config  
        JedisPoolConfig poolConfig = new JedisPoolConfig();  
        
        // 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。  
        poolConfig.setMaxIdle(10);  
        
        // 控制一个pool最多有多少个jedis实例。  
        poolConfig.setMaxTotal(100);  
        
        // 表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；  
        poolConfig.setMaxWaitMillis(2000);
        
        // 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；  
        poolConfig.setTestOnBorrow(true);  
	
        // 通过Jedis连接池创建一个Sentinel连接池  
        @SuppressWarnings("resource")
		JedisSentinelPool pool = new JedisSentinelPool("mymaster", sentinels,poolConfig);  
        
        // 获取master的主机和端口  
        HostAndPort currentHostMaster = pool.getCurrentHostMaster(); 
        System.out.println(currentHostMaster.getHost() + "--"+ currentHostMaster.getPort());  
        
       
        
        // 从Sentinel池中获取资源  
        Jedis resource = pool.getResource();  
        // System.out.println(resource.info());
        
        // 打印资源中key为name的值  
        System.out.println(resource.get("name"));  
        
        // 关闭资源  
        resource.close();  
		
		

	}

}
