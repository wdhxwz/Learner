package com.wangdh.learner.base.jvm;

/**
 * -server : jvm使用server模式 -Xmx : 指定最大堆空间 -Xms : 指定最小堆空间 -XX:DoEscapeAnalysis :
 * 启动逃逸分析 -XX:+PrintGC ： 打印GC日志
 * 
 * -server -Xmx10m -Xms10m -XX:+DoEscapeAnalysis -XX:+PrintGC
 * 
 * @author wdhcxx
 *
 */
public class OnStackTest {
	public static class User {
		public int id = 0;
		public String name = "";
	}

	public static void alloc() {
		User user = new User();
		user.id = 15;
		user.name = "wangdh";
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000000; i++) {
			alloc();
		}
		long end = System.currentTimeMillis();
		System.out.println((end - start));
	}
}
