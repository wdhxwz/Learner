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

		
		BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y; // 输入两个值，返回一个值
		System.out.println(addExplicit.apply(100L, 100L));

		// 函数接口
		Predicate<Integer> atLeast5 = x -> x > 5; // 输入一个值，返回 boolean
		System.out.println(atLeast5.test(10));
		
		Consumer<Integer> consumer = x -> System.out.println(x); // 输入一个值，返回void
		consumer.accept(20);
		
		Function<Integer, String> ff = x -> x.toString(); // 输入一个值，返回一个值
		System.out.println(ff.apply(120));
		
		Supplier<Integer> supplier = () -> 5; // 无参输入，返回一个值
		System.out.println(supplier.get());
		
		UnaryOperator<Integer> unaryOperator = x -> x; // 输入一个值，返回一个值
		System.out.println(unaryOperator.apply(220));
	}
}
