package com.wangdh.learner.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:*application.xml");

		AopTestBean aopTestBean = context.getBean(AopTestBean.class);
		aopTestBean.sayHello();
		aopTestBean.sayHello("wangdh");

		AopTestBean aopTestBean2 = context.getBean(AopTestBean.class);
		try {
			aopTestBean2.aaa();
		} catch (Exception e) {
			System.out.println(e);
		}

		System.exit(1);
	}
}
