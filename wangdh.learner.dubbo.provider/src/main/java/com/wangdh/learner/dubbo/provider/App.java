package com.wangdh.learner.dubbo.provider;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:root.xml");
		context.start();
		System.out.println("dubbo ...");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
