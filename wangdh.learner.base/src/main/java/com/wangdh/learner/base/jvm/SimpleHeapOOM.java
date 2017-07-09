package com.wangdh.learner.base.jvm;

import java.util.ArrayList;

/**
 * 堆内存溢出测试：OutOfMemory
 * 
 * @author wdhcxx
 *
 */
public class SimpleHeapOOM {
	public static void main(String[] args) {
		ArrayList<byte[]> list = new ArrayList<>();
		for (int i = 0; i < 2800; i++) {
			list.add(new byte[1000 * 1000]);
		}
		System.out.println(Runtime.getRuntime().maxMemory()/1000/1000);
	}
}