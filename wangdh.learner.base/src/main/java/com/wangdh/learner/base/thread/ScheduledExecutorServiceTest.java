package com.wangdh.learner.base.thread;

import java.io.IOException;
import java.util.Timer;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

/**
 * 替代Timer
 * 
 * @author PC
 *
 */
public class ScheduledExecutorServiceTest {
	private static int corePoolSize = 10;
	private static ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(
			corePoolSize, new BasicThreadFactory.Builder()
					.namingPattern("example-schedule-pool-%d").daemon(true)
					.build());

	public static void main(String[] args) {
		// executorService.schedule(new Runnable() {
		// @Override
		// public void run() {
		// System.out.println("只执行一次...");
		// }
		// }, 1, TimeUnit.SECONDS);

		// 每三秒执行一次，每次执行的实际间隔 = Math.max(指定间隔,每次执行消耗时间)
		executorService.scheduleAtFixedRate(new MyTask(), 2, 2,
				TimeUnit.SECONDS);

		// 每7秒执行一次，每次执行的时间间隔 = 指定间隔 + 每次执行消耗时间
		// executorService.scheduleWithFixedDelay(new Runnable() {
		// @Override
		// public void run() {
		// System.out.println(System.currentTimeMillis() / 1000
		// + ",两次执行间隔3秒,中间sleep 4秒...");
		// try {
		// Thread.sleep(4 * 1000);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// }
		// }, 2, 3, TimeUnit.SECONDS);

		Timer timer = new Timer(true);
		timer.schedule(new MyTask(), 1000);
		
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}