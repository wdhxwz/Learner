package com.wangdh.learner.base.jvm.classloader;

public class Parent {
	static {
		System.out.println("parent init...");
	}
	public static int age = 100;
}
