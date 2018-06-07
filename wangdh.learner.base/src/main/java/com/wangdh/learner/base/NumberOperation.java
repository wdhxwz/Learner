package com.wangdh.learner.base;

/**
 * @Auther: Administrator
 * @Date: 2018/5/30 18:00
 * @Description:
 */
public class NumberOperation {
    public static void main(String[] args){
        // 位运算：或，有一个为1，则为1
        // >>> 无符号右移
        int cap = 165535;
        int n = cap - 1;
        System.out.println(n >>> 1);
        n |= n >>> 1; // n >>> 1 这里得到的结果相当于 n/2 向下取整

        // 2 -1 =2
        // 2-2 = 4
        // 2-4 = 16
        // 2-8 = 256
        // 2-16 = 65535

        System.out.println(n);
        n |= n >>> 2;
        System.out.println(n);
        n |= n >>> 4;
        System.out.println(n);
        n |= n >>> 8;
        System.out.println(n);
        n |= n >>> 16;

        System.out.println(n);

        System.out.println(1 << 30);


        int[] array = new int[10];
        System.out.println(array.length);
    }
}
