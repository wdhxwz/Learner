package com.wangdh.learner.redis.lock;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheLockInterceptor implements InvocationHandler {
	private static Logger logger = LoggerFactory.getLogger(CacheLockInterceptor.class);

	/**
	 * 出错的次数
	 */
	public static int ErrorCount = 0;
	private Object proxied;

	public CacheLockInterceptor(Object proxy) {
		this.proxied = proxy;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		CacheLock cacheLock = method.getAnnotation(CacheLock.class);
		if (cacheLock == null || args == null || args.length == 0) {
			if (logger.isDebugEnabled()) {
				logger.debug(proxy.getClass().getName() + method.getName() + ",no cacheLock annotation");
			}
			return method.invoke(proxied, args);
		}

		// 获得方法中参数的注解
		Annotation[][] annotations = method.getParameterAnnotations();
		Object lockObject = getLockedObject(annotations, args);
		if (lockObject == null) {
			if (logger.isDebugEnabled()) {
				logger.debug(proxy.getClass().getName() + method.getName()
						+ ",no ParameterAnnotations cacheLock annotation");
			}
			return method.invoke(proxied, args);
		}
		
		String objectValue = lockObject.toString();
		RedisLock lock = new RedisLock(cacheLock.lockedPrefix(), objectValue);
		boolean result = lock.lock(cacheLock.timeOut(), cacheLock.expireTime());
		if(!result){//取锁失败
			ErrorCount += 1;
			throw new CacheLockException("get lock fail");
			
		}
		try{
			//执行方法
			return method.invoke(proxied, args);
		}finally{
			System.out.println("intecepor 释放锁");
			lock.unlock();//释放锁
		}
	}

	private Object getLockedObject(Annotation[][] annotations, Object[] args) {
		if (null == annotations || annotations.length == 0) {
			return null;
		}

		int index = -1;
		for (int i = 0; i < annotations.length; i++) {
			for (int j = 0; j < annotations[i].length; j++) {
				if (annotations[i][j] instanceof LockedComplexObject) {
					index = i;
					try {

					} catch (Exception e) {
						logger.warn("注解对象中没有该属性" + ((LockedComplexObject) annotations[i][j]).field());
						return null;
					}
				}

				if (annotations[i][j] instanceof LockedObject) {
					index = i;
					break;
				}
			}
		}
		return index == -1 ? null : args[index];
	}
}