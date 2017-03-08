package com.wangdh.learner.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws InterruptedException {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:*application.xml");

		AopTestBean aopTestBean = context.getBean(AopTestBean.class);
		aopTestBean.sayHello();
		aopTestBean.sayHello("wangdh");
		
		AopTestBean aopTestBean2 = context.getBean(AopTestBean.class);
		
		aopTestBean2.aaa();

		System.exit(1);
	}
}
