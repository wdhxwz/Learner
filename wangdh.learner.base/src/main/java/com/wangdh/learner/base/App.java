package com.wangdh.learner.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws InterruptedException {
		List<String> list = new ArrayList<String>();
		for (String string : list) {
			System.out.println(string);
		}

		String aaa = "sb:";
		String bbb = "123:";
		System.out.println(String.valueOf(aaa) + System.currentTimeMillis());
		//Thread.sleep(1);
		System.err.println(bbb + System.currentTimeMillis());
		Thread.sleep(1);
		System.out.println("Hello World!" + System.currentTimeMillis());
		Thread.sleep(1);
		System.err.println("777:" + System.currentTimeMillis());
		
		int a=2560;
		int b=2560;
		Integer c=2560;
		Integer d=2560;
		System.out.println(a==b);
		System.out.println(a==c);
		System.out.println(c==d);
	}
}
