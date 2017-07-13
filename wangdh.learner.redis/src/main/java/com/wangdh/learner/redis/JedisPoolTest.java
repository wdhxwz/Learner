/**
 * 
 */
package com.wangdh.learner.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author 王东鸿
 * @Copyright (c) 2016, frontpay.cn
 * @date 2017年1月12日 下午1:27:28
 */
public class JedisPoolTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			JedisPool jedisPool = new JedisPool("127.0.0.1");
			
			Jedis jedis = jedisPool.getResource();
			//jedis.auth("admin");
			jedis.set("age", "21");
			System.out.println(jedis.get("age"));
			jedis.close();
			jedisPool.close();
			jedisPool.destroy();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}