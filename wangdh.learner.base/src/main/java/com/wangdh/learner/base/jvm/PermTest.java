package com.wangdh.learner.base.jvm;

import com.wangdh.learner.base.cglib.Base;
import com.wangdh.learner.base.cglib.CglibProxy;
import com.wangdh.learner.base.cglib.Factory;

/**
 * 方法区测试
 * 
 * -XX:+PrintGCDetails -XX:PermSize=5M -XX:MaxPermSize=5m
 * 
 * @author wdhcxx
 *
 */
public class PermTest {

	public static void main(String[] args) {
		int i = 0;
		try {
			CglibProxy proxy = new CglibProxy();

			for (int j = 0; j < 1000000; j++) {

				// base为生成的增强过的目标类
				Base base = Factory.getInstance(proxy);
				base.add();
			}

		} catch (Exception e) {
			System.out.println("total create count = " + i);
		}

	}

}
