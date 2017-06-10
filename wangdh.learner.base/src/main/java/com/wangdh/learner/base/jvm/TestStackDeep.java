/**
 * 
 */
package com.wangdh.learner.base.jvm;

/**
 * 测试最大调用深度，与最大栈空间相关，可以通过参数 -Xss指定
 * 
 * @author wdhcxx
 *
 */
public class TestStackDeep {

	private static int count = 0;

	public static void call() {
		count++;
		call();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			call();
		} catch (Throwable e) {
			System.out.println("deep of calling = " + count);
			// e.printStackTrace();
		}
	}
}
