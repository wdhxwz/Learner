package com.wangdh.learner.base.thread;

/**
 * 线程新建
 * 
 * @author wdhcxx
 *
 */
public class NewThread {

	public static void main(String[] args) {
		Thread thread = new Thread() {
			@Override
			public void run() {
				int i = 10;
				while (i > 0) {
					System.out.println("a new thread is coming...");
					i--;
				}
			}
		};
		thread.setName("new-thread");
		thread.start();

		// stop()方法比较暴力，会强行将执行了一半的线程终止
		// thread.stop();
	}
}