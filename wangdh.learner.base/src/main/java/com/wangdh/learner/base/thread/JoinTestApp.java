package com.wangdh.learner.base.thread;

/**
 * 线程Join()方法测试
 * 
 * @author wdhcxx
 *
 */
public class JoinTestApp {
	private  static int sum = 0;

	public static class AddThread extends Thread {
		public void run() {
			for (int i = 0; i < 1000; i++){
				sum++;
			}
			System.out.println("线程1");
		}
	}
	
	public static class AddThread2 extends Thread {
		public void run() {
			for (int i = 0; i < 1000; i++){
				sum++;
			}
            System.out.println("线程2");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		AddThread addThread = new AddThread();
        AddThread2 addThread2 = new AddThread2();
		addThread.start();
		addThread.join();

		addThread2.start();
	    addThread2.join();
		
		System.out.println(sum);
	}

}
