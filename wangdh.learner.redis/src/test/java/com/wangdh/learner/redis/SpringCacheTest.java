/**
 * 
 */
package com.wangdh.learner.redis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wangdh.learner.springCache.UserEntity;
import com.wangdh.learner.springCache.UserService;

/**
 * @author wdhcxx
 *
 */
public class SpringCacheTest extends BaseTest {

	@Autowired
	UserService userService;

	@Test
	public void cacheTest() {
		UserEntity user1 = userService.getUser(1 + "");
		UserEntity user2 = userService.getUser(2 + "");
		UserEntity user3 = userService.getUser(1 + "");
	}
}
