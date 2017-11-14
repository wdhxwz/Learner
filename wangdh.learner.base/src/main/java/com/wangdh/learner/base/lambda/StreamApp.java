package com.wangdh.learner.base.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 流：Stream
 * 
 * @author wdhcxx
 *
 */
public class StreamApp {
	public static void main(String[] args) {
		/** 迭代方式 **/
		List<Artist> artists = new ArrayList<>();
		// 内部迭代：Lambda
		Long count = artists.stream()
				.filter(artist -> artist.getOrigin() == "London").count();

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
		list.stream().map(num -> num.toString())
				.forEach(num -> System.out.println(num));

		/** 常用的流操作 **/
		// collect()
		List<String> collected = Stream.of("a", "b", "c").collect(
				Collectors.toList());

		// map()
		List<String> upperCaseList = collected.stream()
				.map((s) -> s.toUpperCase()).collect(Collectors.toList());

		// filter()
		upperCaseList.stream().filter((s) -> s == "A").count();

		// flatMap():将多个Stream连接成一个
		List<Integer> together = Stream.of(asList(1, 2), asList(3, 4))
				.flatMap(numbers -> numbers.stream())
				.collect(Collectors.toList());
		output(together);

		// max()、min()、count()
		Integer maxNum = together.stream()
				.max(Comparator.comparing(num -> num)).get();
		Integer minNum = together.stream()
				.min(Comparator.comparing(num -> num)).get();
		Integer count2 = (int) together.stream().filter((num) -> num % 2 == 0)
				.count();
		System.out.println("max=" + maxNum + ",min=" + minNum + ",count="
				+ count2);

		// reduce()
		int sum = Stream.of(1, 2, 3).reduce(0, (acc, element) -> acc + element);
		System.out.println("sum=" + sum);

		/** 类库 **/

	}

	@SafeVarargs
	private static <T> List<T> asList(T... values) {
		List<T> list = new ArrayList<T>();
		for (T t : values) {
			list.add(t);
		}

		return list;
	}

	private static <T> void output(List<T> list) {
		list.stream().forEach((s) -> System.out.println(s));
	}
}
