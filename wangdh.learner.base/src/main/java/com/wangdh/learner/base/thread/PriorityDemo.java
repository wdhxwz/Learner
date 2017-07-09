package com.wangdh.learner.base.thread;

import java.util.HashMap;
import java.util.Map;

/**
 * 线程优先级测试
 * 
 * @author wdhcxx
 *
 */
public class PriorityDemo {
	public static class HighPriorityThread extends Thread {
		static int count = 0;

		public void run() {
			long start = System.currentTimeMillis();
			while (true) {
				synchronized (PriorityDemo.class) {
					count++;
					if (count > 100000000) {
						System.out.println("HighPriorityThread is complete");
						System.out.println(System.currentTimeMillis() - start);
						break;
					}
				}
			}
		}
	}

	public static class LowPriorityThread extends Thread {
		static int count = 0;

		public void run() {
			long start = System.currentTimeMillis();
			while (true) {
				synchronized (PriorityDemo.class) {
					count++;
					if (count > 100000000) {
						System.out.println("LowPriorityThread is complete");
						System.out.println(System.currentTimeMillis() - start);
						break;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		HighPriorityThread highPriorityThread = new HighPriorityThread();
		LowPriorityThread lowPriorityThread = new LowPriorityThread();
		highPriorityThread.setPriority(Thread.MAX_PRIORITY);
		lowPriorityThread.setPriority(Thread.MIN_PRIORITY);
		highPriorityThread.start();
		lowPriorityThread.start();
		
		Map<String, String> map = new HashMap<>();
		map.put("abc", "123");
		map.get("abc");
	}
}
