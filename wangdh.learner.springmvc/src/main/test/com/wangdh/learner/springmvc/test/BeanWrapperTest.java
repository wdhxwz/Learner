package com.wangdh.learner.springmvc.test;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.PropertyValue;

/**
 * 测试BeanWrapper
 * </br> BeanWrapper是Spring提供的一个用来操作JavaBean属性的工具
 * </br> 使用BeanWrapper可以直接修改一个对象的属性
 * </br> 示例如下：
 */
public class BeanWrapperTest {

	public static void main(String[] args) {
		User user = new User();
		BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(user);
		
		beanWrapper.setPropertyValue("name", "user-01");
		System.out.println(user.getName());
		
		PropertyValue propertyValue = new PropertyValue("name", "user-02");
		beanWrapper.setPropertyValue(propertyValue);
		System.out.println(user.getName());
	}
}