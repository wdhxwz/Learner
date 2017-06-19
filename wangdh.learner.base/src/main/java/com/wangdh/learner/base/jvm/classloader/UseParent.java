package com.wangdh.learner.base.jvm.classloader;

/**
 * -XX:+TraceClassLoading
 * @author wdhcxx
 *
 *	引用一个字段时，只有直接定义该字段的类，才会被初始化，但其他类会被系统加载
 */
public class UseParent {

	public static void main(String[] args) {
		System.out.println(Child.age);
	}
}
