package com.wangdh.learner.mybatis;

import com.wangdh.learner.mybatis.Utils.MapperProxy;
import com.wangdh.learner.mybatis.entity.UserEntity;
import com.wangdh.learner.mybatis.mapper.UserMapper;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		// System.out.println(1 + 2 + "" + 2);
		MapperProxy mapperProxy = new MapperProxy();
		UserMapper mapper = mapperProxy.newInstance(UserMapper.class);

		UserEntity userEntity = mapper.getUser("1001");
		System.out.println("id=" + userEntity.getId());
		System.out.println("name=" + userEntity.getName());
		System.out.println("age=" + userEntity.getAge());

		System.out.println("OK");
	}
}
