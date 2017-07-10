package com.wangdh.learner.base.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 流：Stream
 * 
 * @author wdhcxx
 *
 */
public class StreamApp {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			list.add(random.nextInt(100));
		}
		for (Integer integer : list) {
			System.out.println(integer);
		}
		list.stream().map(num -> num.toString()).forEach(num -> System.out.println(num));
	}
}
