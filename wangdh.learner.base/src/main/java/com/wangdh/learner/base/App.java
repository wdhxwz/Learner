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
	}
}
