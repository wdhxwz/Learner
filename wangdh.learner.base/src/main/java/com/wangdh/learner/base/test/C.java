package com.wangdh.learner.base.test;

public class C implements A, B {

	@Override
	public void sayB() {
		System.out.println("say from B");
	}

	@Override
	public void sayA() {
		System.out.println("say from A");
	}
}
