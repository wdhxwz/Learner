package com.wangdh.learner.base.thread;

/**
 * 多线程下的Long类型测试
 * <p>
 * long -> 8个字节，64位 </br>
 * 32位系统中，读写不是原子性
 * </p>
 * 
 * @author wangdh 2017年6月30日下午3:56:18
 */
public class MultiThreadLong {
	private static long tLong = 0L;

	public static class ChangeT implements Runnable {
		private long t0;

		public ChangeT(long t) {
			this.t0 = t;
		}

		@Override
		public void run() {
			while (true) {
				MultiThreadLong.tLong = t0;
				Thread.yield();
			}
		}
	}

	public static class ReadT implements Runnable {
		@Override
		public void run() {
			while (true) {
				long temp = MultiThreadLong.tLong;
				if (temp != 111L && temp != -999L && temp != 333L && temp != -444L) {
					System.out.println(temp);
					Thread.yield();
				}
			}
		}
	}

	public static void main(String[] args) {
		new Thread(new ChangeT(111L)).start();
		new Thread(new ChangeT(-999L)).start();
		new Thread(new ChangeT(333L)).start();
		new Thread(new ChangeT(-444L)).start();
		new Thread(new ReadT()).start();
	}
}