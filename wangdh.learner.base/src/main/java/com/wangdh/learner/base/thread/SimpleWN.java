package com.wangdh.learner.base.thread;

/**
 * wait()和notify()测试
 * 
 * @author wdhcxx
 *
 */
public class SimpleWN {
	final static Object OBJECT = new Object();

	public static class T1 extends Thread {
		public void run() {
			synchronized (OBJECT) {
				System.out.println(System.currentTimeMillis() + ":T1 start...");
				try {
					System.out.println(System.currentTimeMillis() + ":T1 wait for OBJECT...");
					OBJECT.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(System.currentTimeMillis() + ":T1 end...");
			}
		}
	}
	
	public static class T3 extends Thread {
		public void run() {
			synchronized (OBJECT) {
				System.out.println(System.currentTimeMillis() + ":T3 start...");
				try {
					System.out.println(System.currentTimeMillis() + ":T3 wait for OBJECT...");
					OBJECT.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(System.currentTimeMillis() + ":T3 end...");
			}
		}
	}

	public static class T2 extends Thread {
		public void run() {
			synchronized (OBJECT) {
				System.out.println(System.currentTimeMillis() + ":T2 start notify one Thread...");
				System.out.println(System.currentTimeMillis() + ":T2 end...");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				OBJECT.notify();
			}
		}
	}

	public static void main(String[] args) {
		Thread t1 = new T1();
		Thread t2 = new T2();
		Thread t3 = new T3();
		t1.start();
		t2.start();
		t3.start();
	}
}
