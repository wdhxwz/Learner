package com.wangdh.learner.base.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SPIDemo {

	public static void main(String[] args) {
		ServiceLoader<Spi> serviceLoader = ServiceLoader.load(Spi.class);
		
		Iterator<Spi> iterator = serviceLoader.iterator();
		while(iterator.hasNext()){
			Spi spi = iterator.next();
			System.out.println(spi.getClass().getName());
			System.out.println(spi.sayHello());
		}
		
//		for (Spi spi : serviceLoader) {
//			System.out.println(spi.getClass().getName());
//			System.out.println(spi.sayHello());
//		}
		
		System.out.println("OK");
	}
}
