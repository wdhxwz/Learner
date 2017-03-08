package com.wangdh.learner.aop;

import org.springframework.stereotype.Component;

@Component
public class AopTestBean {
	public void sayHello() {
		System.out.println("Hello ...");
	}

	public void sayHello(String name) throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("Hello " + name);
	}

	public void aaa() {
		System.out.println("aaa");
	}
}
