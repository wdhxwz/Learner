package com.wangdh.learner.rop.test;

import com.wangdh.learner.rop.client.UserServiceClient;

public class UserServiceTest1 {

	private static final String SERVER_URL = "http://localhost:8080/wangdh.learner.rop/router";
//	private static final String APP_KEY = "00001";
//	private static final String APP_SECRET = "abcdeabcdeabcdeabcdeabcde";
	private static final String APP_KEY = "00003";
	private static final String APP_SECRET = "abcdeabcdeabcdeabcdeaaaaa";

	public static void main(String[] args) {
		UserServiceClient userServiceClient = new UserServiceClient(APP_KEY, APP_SECRET, SERVER_URL);
		System.out.println("【user.getSession】" + userServiceClient.getSession("1.0"));
		System.out.println("【user.login】" + userServiceClient.login("wangdh", "qwertyuiop", ""));
		System.out.println("【user.getSession】" + userServiceClient.getSession("1.0"));
		System.out.println("【user.logout】" + userServiceClient.logout(""));
		System.out.println("【user.getSession】" + userServiceClient.getSession("1.0"));
	}
}
