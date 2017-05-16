package com.wangdh.learner.base.reflector;

public class App_01 {

	public static void main(String[] args) {
		UserManager userManager = new UserManagerProxy(new UserManagerImp());
		userManager.getUser("123");
		System.out.println();
		userManager.deleteUser("321");
		
		System.out.println("OK");
	}

}
