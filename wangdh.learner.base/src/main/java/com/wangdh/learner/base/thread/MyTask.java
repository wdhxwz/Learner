package com.wangdh.learner.base.thread;

import java.io.Serializable;
import java.util.TimerTask;

/**
 * 执行的任务
 * 
 * @author PC
 *
 */
public class MyTask extends TimerTask implements Serializable {
	private static final long serialVersionUID = -7615767507221652379L;

	@Override
	public void run() {
		System.out.println(System.currentTimeMillis() / 1000
				+ ",MyTask 两秒执行一次,中间sleep 3秒...");
		try {
			Thread.sleep(3 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}