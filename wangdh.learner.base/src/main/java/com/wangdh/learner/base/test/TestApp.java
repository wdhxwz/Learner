package com.wangdh.learner.base.test;

public class TestApp {

	public static void main(String[] args) {
		C c = new C();
		B b = (B)c;
		A a = (A)b;
		a.sayA();
		b.sayB();
	}
}
