package com.wangdh.learner.base.jvm.classloader;

public class Child extends Parent{
	static{
		System.out.println("child init...");
	}
	
	public void show(){
		
	}
	
	public static void main(String[] args) {
		Child child = new Child();
		child.show();
	}
}
