package com.wangdh.learner.base.jvm.locker;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程安全测试
 * 
 * @author wdhcxx
 *
 */
public class ThreadUnSafe {
	public static List<Integer> numberList = new ArrayList<Integer>();

	public static class AddToList implements Runnable {
		int startNum = 0;

		public AddToList(int startNumber) {
			this.startNum = startNumber;
		}

		@Override
		public void run() {
			int count = 0;
			while (count < 10000000) {
				numberList.add(startNum);
				startNum += 1;
				count++;
			}
		}
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new AddToList(0));
		Thread t2 = new Thread(new AddToList(1));
		t1.start();
		t2.start();
		System.out.println("OK");
	}
}
