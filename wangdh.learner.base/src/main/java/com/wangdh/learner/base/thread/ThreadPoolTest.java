package com.wangdh.learner.base.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池测试
 * <p>
 * Executors : 线程池工厂
 * <br/>
 * newFixedThreadPool():返回一个固定线程数量的线程池，当新的任务提交时，线程池如果有空闲线程，则立即执行，
 * 否则，新任务会暂存在一个任务队列中。
 * <br/>
 * newScheduledThreadPool():
 * <br/>
 * newSingleThreadExecutor():创建一个只有单个线程的线程池
 * <br/>
 * newCachedThreadPool():返回一个可根据实际情况调整线程数量的线程池，优先使用空闲线程，
 * 当所有线程都在工作时，又有新的任务提交，会创建新的线程处理任务。可指定最大线程数
 * <br/>
 * </p>
 * @author wdhcxx
 *
 */
public class ThreadPoolTest {
	public static class MyTask implements Runnable{

		@Override
		public void run() {
			System.out.println(System.currentTimeMillis()+":Thread Id:"+Thread.currentThread().getId());
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		MyTask task = new MyTask();
		ExecutorService executorService = null;
				// Executors.newFixedThreadPool(5);
		// executorService = Executors.newCachedThreadPool();
		executorService = Executors.newSingleThreadExecutor();
		for(int i = 0;i<10;i++){
			executorService.submit(task);
		}
	}
}
