package com.wangdh.learner.base.jvm;

import java.lang.reflect.InvocationTargetException;

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

			for (int j = 0; j < 1; j++) {

				// base为生成的增强过的目标类
				 Base base = Factory.getInstance(proxy);
				 base.add();
			}
			Base base = new Base();
			base.getClass().getMethod("add").invoke(base);

		} catch (InvocationTargetException  e) {
			System.out.println("total create count = " + i);
//			StringWriter writer = new StringWriter();
//			e.getCause().printStackTrace(new PrintWriter(writer, true));
//			System.out.println("详细的异常信息:" + writer.toString());
			System.out.println(e.getTargetException().getMessage());
			
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}