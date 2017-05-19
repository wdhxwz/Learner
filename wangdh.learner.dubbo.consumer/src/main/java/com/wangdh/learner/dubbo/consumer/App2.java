package com.wangdh.learner.dubbo.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangdh.learner.dubbo.api.ISampleService;

public class App2 {

	 public static void main( String[] args ) throws InterruptedException
	    {
	    	@SuppressWarnings("resource")
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:dubbo.xml");
			context.start();
			while (true) {
				ISampleService demoService = (ISampleService) context.getBean("sampleService");
				String hello = "";
				try {
					hello = demoService.sayHello("wangdh");
					demoService.test();
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " " + hello);
				
				Thread.sleep(1000);
			}
	    }
}
