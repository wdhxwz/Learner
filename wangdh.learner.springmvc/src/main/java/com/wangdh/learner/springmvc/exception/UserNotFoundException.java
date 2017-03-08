package com.wangdh.learner.springmvc.exception;

public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = -626224652747742660L;

	public UserNotFoundException(String userName) {
		super("User Not Found With:" + userName);
	}
}