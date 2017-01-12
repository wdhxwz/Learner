/**
 * 
 */
package com.wangdh.learner.redis;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 王东鸿
 * @Copyright (c) 2016, frontpay.cn
 * @date 2017年1月12日 下午1:41:29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-redis.xml" })
public class RedisTemplateTest {
	@Resource(name = "redisTemplate")
	private RedisTemplate<String, String> template;

	@Resource(name = "redisTemplate")
	private ValueOperations<String, Object> vOps;

	@Test
	public void test() {
		template.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				byte[] key = "tempkey2".getBytes();
				byte[] value = "tempvalue2".getBytes();
				connection.set(key, value);
				return true;
			}
		});
	}

	/**
	 * valueOperation数据类型的操作
	 */
	@Test
	public void test1() {
		vOps.set("value2", "code2");
	}
}
