package com.wangdh.learner.base.reflector;

public class UserManagerImp implements UserManager {

	@Override
	public String getUser(String id) {
		System.out.println("根据用户id获取用户");
		return "我是实际干活的：" + id;
	}

	@Override
	public boolean deleteUser(String id) {
		System.out.println("根据用户id删除用户,默认返回false");
		return false;
	}
}
