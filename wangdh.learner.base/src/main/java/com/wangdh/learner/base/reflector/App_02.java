package com.wangdh.learner.base.reflector;

public class App_02 {

	public static void main(String[] args) {

		LogHandler logHandler = new LogHandler();
		UserManager userManager = (UserManager) logHandler.newProxyInstance(new UserManagerImp());
		userManager.getUser("wangdh");
	}
}
