package com.wangdh.learner.base.reflector;

public class UserManagerProxy implements UserManager {
	private UserManagerImp userManagerImp = new UserManagerImp();

	public UserManagerProxy() {

	}

	public UserManagerProxy(UserManagerImp userManagerImp) {
		this.userManagerImp = userManagerImp;
	}

	@Override
	public String getUser(String id) {
		System.out.println("我只是个代理,获取用户前");
		String result = userManagerImp.getUser(id);
		System.out.println("我只是个代理,获取用户后");
		
		return result;
	}

	@Override
	public boolean deleteUser(String id) {
		System.out.println("我只是个代理,删除用户前");
		userManagerImp.deleteUser(id);
		System.out.println("我只是个代理,删除用户后");
		return true;
	}
}
