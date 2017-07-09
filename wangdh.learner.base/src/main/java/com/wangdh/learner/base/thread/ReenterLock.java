package com.wangdh.learner.base.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁测试
 * 
 * @author wdhcxx
 *
 */
public class ReenterLock implements Runnable {
	public static ReentrantLock lock = new ReentrantLock();
	public static int i = 0;

	@Override
	public void run() {
		lock.lock();
		try {
			System.out.println("start:"+System.currentTimeMillis());
			for (int j = 0; j < 100000000; j++) {
				i++;
			}
		} finally {
			System.out.println("end1:" + System.currentTimeMillis());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("end2:" + System.currentTimeMillis());
			lock.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ReenterLock t1 = new ReenterLock();
		Thread thread1 = new Thread(t1);
		Thread thread2 = new Thread(t1);

		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		System.out.println(i);
	}
}
