package com.wangdh.learner.base;

public class App2 {

	public static void main(String[] args) {
		Integer i1 = 3;
		
		System.out.println(i1.hashCode());
		i1++;
		System.out.println(i1.hashCode());
		
		String abc= "abdbdbdbdb";
		System.out.println(abc.hashCode());
	}
}
