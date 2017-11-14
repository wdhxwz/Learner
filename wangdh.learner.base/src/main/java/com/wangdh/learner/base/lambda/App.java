package com.wangdh.learner.base.lambda;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * Lambda表达式
 * 
 * @author wdhcxx
 *
 */
public class App {

	public static void main(String[] args) {

		Runnable noArguments = () -> System.out.println("Hello world");
		Runnable multiStatement = () -> {
			System.out.print("Hello");
			System.out.println(" World.");
		};
		noArguments.run();
		multiStatement.run();

		// 输入两个值，返回一个值
		BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;
		System.out.println(addExplicit.apply(100L, 100L));

		/** 函数接口 **/
		// 输入一个值，返回 boolean
		Predicate<Integer> atLeast5 = x -> x > 5;
		System.out.println(atLeast5.test(10));

		// 输入一个值，返回void
		Consumer<Integer> consumer = x -> System.out.println(x);
		consumer.accept(20);

		// 输入一个值，返回一个值
		Function<Integer, String> ff = x -> x.toString();
		System.out.println(ff.apply(120));

		// 无参输入，返回一个值
		Supplier<Integer> supplier = () -> 5;
		System.out.println(supplier.get());

		// 输入一个值，返回一个值
		UnaryOperator<Integer> unaryOperator = x -> x;
		System.out.println(unaryOperator.apply(220));
	}
}