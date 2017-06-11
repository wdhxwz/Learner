package com.wangdh.learner.base.reflector;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class App03 {

	public static void main(String[] args) {
		test1();
		test2();
	}

	// 1000000000 95
	// 100000000 18
	private static void test1() {
		long start = System.currentTimeMillis();
		App03Test app03Test = new App03Test();
		for (int i = 0; i < 100000000; i++) {
			app03Test.setCount(100);
			app03Test.setPrice(10);
			app03Test.setTotalPrice(app03Test.sum());
		}
		long end = System.currentTimeMillis();
		System.out.println((end - start) + "毫秒");
	}

	// 1000000000 66535毫秒
	// 100000000 6788毫秒 71855毫秒(没缓存)
	// 10000000 7879毫秒(没缓存)
	private static void test2() {
		Map<String, Field> fieldCache = new HashMap<String, Field>();
		Class<?> app03TestClass = App03Test.class;
		Field[] fields = app03TestClass.getDeclaredFields();
		for (Field field : fields) {
			fieldCache.put(field.getName(), field);
		}

		Map<String, Method> methodCache = new HashMap<String, Method>();
		Method[] methods = app03TestClass.getDeclaredMethods();
		for (Method method : methods) {
			methodCache.put(method.getName(), method);
		}

		long start = System.currentTimeMillis();
		App03Test app03Test = new App03Test();
		try {
			for (int i = 0; i < 100000000; i++) {
				methodCache.get("setCount").invoke(app03Test, 100);
				methodCache.get("setPrice").invoke(app03Test, 10);
				methodCache.get("setTotalPrice").invoke(app03Test, methodCache.get("sum").invoke(app03Test));
				// app03Test.getClass().getDeclaredMethod("setCount",int.class).invoke(app03Test,
				// 100);
				// app03Test.getClass().getDeclaredMethod("setPrice",double.class).invoke(app03Test,
				// 100);
				// app03Test.getClass().getDeclaredMethod("setTotalPrice",double.class).invoke(app03Test,
				// app03Test.getClass().getDeclaredMethod("sum").invoke(app03Test));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		long end = System.currentTimeMillis();
		System.out.println((end - start) + "毫秒");
	}
}
