package com.wangdh.learner.base.thread;

import java.util.concurrent.*;

/**
 * 线程池测试
 * <p>
 * Executors : 线程池工厂
 * <br/>
 * newFixedThreadPool():返回一个固定线程数量的线程池，当新的任务提交时，线程池如果有空闲线程，则立即执行，
 * 否则，新任务会暂存在一个任务队列中。
 * <br/>
 * newScheduledThreadPool():创建执行定时任务的线程池
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
	public static class MyTask implements Runnable{//{

		@Override
		public void run() {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(System.currentTimeMillis()+":Thread Id:"+Thread.currentThread().getId());
		}

//        @Override
//        public String call() throws Exception {
//
//            return "";
//        }
    }
	
	public static void main(String[] args) throws InterruptedException {
		MyTask task = new MyTask();
		ThreadPoolExecutor executorService = null;
		// executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        executorService = new ThreadPoolExecutor(5,10,100, TimeUnit.MINUTES,new LinkedBlockingDeque<>(80),new ThreadPoolExecutor.DiscardPolicy());
		// executorService = Executors.newCachedThreadPool();
		// executorService = Executors.newSingleThreadExecutor();
        new ScheduledThreadPoolExecutor(10);
		for(int i = 0;i<90;i++){
			executorService.submit(task);
		}
		Thread.currentThread().join(10000);
        System.out.println(executorService.getActiveCount());
        System.out.println(executorService.getTaskCount());
        System.out.println(executorService.getCompletedTaskCount());
        System.out.println(executorService.getLargestPoolSize());
        System.out.println(executorService.getPoolSize());
	}
}
