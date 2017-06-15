package com.wangdh.learner.base.cglib;

/** 
 * 被代理类，即目标对象target 
 *  
 * @author typ 
 *  
 */  
public class Base {  
    /** 
     * 一个模拟的add方法 
     * @throws Exception 
     */  
    public void add() throws Exception {  
        //System.out.println("add ------------");  
    	throw  new Exception("我是故意跑出来的异常");
    }  
}  