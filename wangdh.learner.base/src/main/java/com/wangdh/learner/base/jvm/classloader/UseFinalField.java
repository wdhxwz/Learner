package com.wangdh.learner.base.jvm.classloader;

/**
 * -XX:+TraceClassLoading
 * @author wdhcxx
 * 直接引用final常量，常量所在的类不会被初始化
 */
public class UseFinalField {
	public static void main(String[] args) {
		boolean aaa = true;
		System.out.println(aaa);
		
		System.out.println(FinalFieldClass.name);
	}
}