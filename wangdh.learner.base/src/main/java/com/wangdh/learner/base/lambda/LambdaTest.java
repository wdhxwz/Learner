package com.wangdh.learner.base.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * 测试并发和同步的耗时
 * 数量		并发		同步
 * 10000	6		50
 * 100000	8		53
 * 1000000	22		61
 * 10000000	34		83
 * @author PC
 *
 */
public class LambdaTest {

	public static void main(String[] args) {
		int size = 10000;
		Random random = new Random();

		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			list.add(random.nextInt(size));
		}

		// 同步流
		long start = System.currentTimeMillis();
		Integer maxNum = list.stream().max(Comparator.comparing(num -> num))
				.get();
		System.out.println("max=" + maxNum);

		long end = System.currentTimeMillis();
		System.out.println("耗时(ms):" + (end - start));

		// 并发流
		start = System.currentTimeMillis();
		maxNum = list.parallelStream().max(Comparator.comparing(num -> num))
				.get();
		System.out.println("max=" + maxNum);

		end = System.currentTimeMillis();
		System.out.println("耗时(ms):" + (end - start));

		
		
	}

}
