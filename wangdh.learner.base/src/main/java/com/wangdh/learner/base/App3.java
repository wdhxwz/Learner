package com.wangdh.learner.base;

/**
 * @author wangdh
 * @Description
 * @date 2018-02-01
 */
public class App3 {
    public static void main(String[] args){
        Float a = 1000.23f;
        Float b = 1000.23f;
        System.out.println(a == b);
        System.out.println(a.equals(b));
        String s = "";
        s.hashCode();


        Integer i1 = 128;
        Integer i2 = 128;
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));
    }
}
