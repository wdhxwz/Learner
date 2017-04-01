package com.wangdh.learner.springmvc.base;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Spring IOC上下文工具类
 * 
 */
public class SpringUtil implements ApplicationContextAware {

	/**
	 * 当前IOC
	 */
	private static ApplicationContext applicationContext;

	/**
	 * 设置当前上下文环境，此方法由spring自动装配
	 */
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		applicationContext = context;
	}

	public static Object getBean(String name) throws BeansException {
		return applicationContext.getBean(name);
	}
	public static <T> T getBean(Class<T> t) {
    	return applicationContext.getBean(t);
    }
}