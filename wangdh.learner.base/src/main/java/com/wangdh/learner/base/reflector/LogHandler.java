package com.wangdh.learner.base.reflector;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LogHandler implements InvocationHandler {
	private Object target;

	public Object newProxyInstance(Object targetObject) {
		this.target = targetObject;

		return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(),
				this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("start-->>");
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
		Object ret = null;
		try {
			/* 原对象方法调用前处理日志信息 */
			System.out.println("satrt-->>");

			// 调用目标方法
			ret = method.invoke(target, args);
			
			/* 原对象方法调用后处理日志信息 */
			System.out.println("success-->>");
		} catch (Exception e) {
			System.out.println("error-->>");
			throw e;
		}
		
		return ret;
	}
}
