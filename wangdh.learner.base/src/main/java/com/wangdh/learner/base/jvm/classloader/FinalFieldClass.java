package com.wangdh.learner.base.jvm.classloader;

public class FinalFieldClass {
	public static final String name="wangdh";
	
	static{
		System.out.println("FinalFieldClass init ...");
	}
}
