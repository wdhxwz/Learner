package com.wangdh.learner.base;

public class App2 {

	public static void main(String[] args) {
		Integer i1 = 3;
		
		System.out.println(i1.hashCode());
		i1++;
		System.out.println(i1.hashCode());
		
		String abc= "abdbdbdbdb";
		System.out.println(abc.hashCode());
		
		String aaa = "aaa";
		String bbb = "aaa";
		System.out.println(aaa == bbb);
		
		String ccc = new String("aaa");
		String ddd = new String("aaa");
		System.out.println(ccc == ddd);
		System.out.println(aaa == ccc);
		System.out.println(aaa == ccc.intern());
		System.out.println(ccc.intern() == ddd.intern());
		System.out.println(ccc.intern());
		
		Test test = new App2().new Test();
		test.say();
	}
	
	class Test{
		protected void say(){
			System.out.println("protected method");
		}
	}
}
