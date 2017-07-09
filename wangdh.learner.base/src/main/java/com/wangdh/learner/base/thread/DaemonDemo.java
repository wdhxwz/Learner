package com.wangdh.learner.base.thread;

/**
 * 守护线程测试
 * @author wdhcxx
 *
 */
public class DaemonDemo {
	public static class DaemonT extends Thread{
		public void run(){
			while(true){
				System.out.println("I am alive");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new DaemonT();
		thread.setDaemon(true);
		thread.start();

		Thread.sleep(2000);
	}

}
