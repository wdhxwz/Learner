package com.wangdh.learner.base.lambda;

import java.util.ArrayList;
import java.util.Iterator;
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
		List<Artist> artists = new ArrayList<>();

		// 内部迭代：Lambda
		Long count = artists.stream().filter(artist -> artist.getOrigin() == "London").count();

		// 外部迭代：foreach循环(封装了迭代的语法糖)
		for (Artist artist : artists) {
			if (artist.getOrigin() == "London") {
				count++;
			}
		}

		// 外部迭代：迭代器方式
		Iterator<Artist> iterator = artists.iterator();
		while (iterator.hasNext()) {
			Artist artist = iterator.next();
			if (artist.getOrigin() == "London") {
				count++;
			}
		}

		// 只描述Stream，最终不产生新集合的方法叫做惰性求值方法：返回值是Stream
		// 最终会从Stream产生值的方法叫做及早求值方法：返回另一个值或void

		List<Integer> list = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			list.add(random.nextInt(100));
		}
		for (Integer integer : list) {
			System.out.println(integer);
		}

		// 这段代码里面的输出语句是不执行的
		list.stream().filter(num -> {
			System.out.println("filter只是个惰性方法");
			return num > 5;
		});
		list.stream().map(num -> num.toString()).forEach(num -> System.out.println(num));

		// 常用的流操作

	}
}
