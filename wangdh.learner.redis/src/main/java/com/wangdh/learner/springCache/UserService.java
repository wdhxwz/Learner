/**
 * 
 */
package com.wangdh.learner.springCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author wdhcxx
 *
 */
@Service
public class UserService {
	private static Map<String, UserEntity> userMap = null;

	static {
		userMap = new HashMap<String, UserEntity>();
		for (Integer index = 0; index < 10; index++) {
			UserEntity userEntity = new UserEntity();
			String name = "user:" + index;
			String sex = index % 3 == 0 ? "男" : "女";
			userEntity.setId(index.toString());
			userEntity.setName(name);
			userEntity.setSex(sex);

			userMap.put(index.toString(), userEntity);
		}
	}

	@Cacheable(value = "userCache:", key = "#id")
	public UserEntity getUser(String id) {
		if (userMap.containsKey(id)) {
			return userMap.get(id);
		}

		return null;
	}

	public UserEntity getUserByName(String userName) {
		Iterator<UserEntity> users = userMap.values().iterator();
		while (users.hasNext()) {
			UserEntity user = users.next();
			if (user.getName().equals(userName)) {
				return user;
			}
		}

		return null;
	}

	public List<UserEntity> getUsers(String sex) {
		List<UserEntity> userList = new ArrayList<UserEntity>();
		Iterator<UserEntity> users = userMap.values().iterator();
		while (users.hasNext()) {
			UserEntity user = users.next();
			if (user.getSex().equals(sex)) {
				userList.add(user);
			}
		}

		return userList;
	}
}
