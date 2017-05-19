package com.wangdh.learner.dubbo.provider;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App2 {
	public static void main( String[] args )
    {
    	@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:root2.xml");
		context.start();
		System.out.println("dubbo2 ...");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
