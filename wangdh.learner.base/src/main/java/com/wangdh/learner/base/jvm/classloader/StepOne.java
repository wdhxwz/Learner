package com.wangdh.learner.base.jvm.classloader;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class StepOne {

	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> clzStr = Class.forName("java.lang.String");
		Method[] methods = clzStr.getDeclaredMethods();
		for (Method method : methods) {
			String mod = Modifier.toString(method.getModifiers());
			System.out.print(mod + " " + method.getName() + "(");
			Class<?>[] ps = method.getParameterTypes();
			if (ps.length == 0)
				System.out.print(")");

			for (int i = 0; i < ps.length; i++) {
				char end = i == ps.length - 1 ? ')' : ',';
				System.out.print(ps[i].getSimpleName() + end);
			}
			System.out.println();
		}
	}
}