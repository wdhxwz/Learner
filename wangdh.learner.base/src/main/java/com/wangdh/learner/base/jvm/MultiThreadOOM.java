package com.wangdh.learner.base.jvm;

/**
 * 太多线程导致OOM
 * 
 * @author wdhcxx
 *
 */
public class MultiThreadOOM {
	public static class SleepThread implements Runnable {

		@Override
		public void run() {
			try {
				Thread.sleep(1000000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10240000; i++) {
			new Thread(new SleepThread()).start();
			System.out.println("Thread " + i + " created");
		}
	}
}
