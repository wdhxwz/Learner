package com.wangdh.learner.base.reflector;

/**
 * 用户管理接口
 * 
 * @author wangdh 2017年5月16日下午5:05:40
 */
public interface UserManager {
	public String getUser(String id);

	public boolean deleteUser(String id);
}
