package com.wangdh.learner.base.jvm;

import java.nio.ByteBuffer;

/**
 * 直接内存溢出测试：
 * -Xmx1g -XX:+PrintGCDetails
 * 
 * @author wdhcxx
 *
 */
public class DirectBufferOOM {

	public static void main(String[] args) {
		for (int i = 0; i < 10240; i++) {
			ByteBuffer.allocateDirect(10240 * 102400);
			System.out.println(i);
		}
	}

}
