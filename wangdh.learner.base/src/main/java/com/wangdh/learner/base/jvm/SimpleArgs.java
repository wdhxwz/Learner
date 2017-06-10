package com.wangdh.learner.base.jvm;

/**
 * 参数传递与最大可用堆
 * @author wdhcxx
 *
 */
public class SimpleArgs {

	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			System.out.println("第" + (i + 1) + "个参数=" + args[i]);
		}
		
		Runtime runtime = Runtime.getRuntime();
		

		System.out.println("最大可用堆空间：" + runtime.maxMemory() / 1000 / 1000 + "M");
	}

}
