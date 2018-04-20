package com.wangdh.learner.base.leetcode;

/**
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。<br/>
 * 注意：不要使用任何内置的库函数，如sqrt。<br/>
 * 1.利用恒等式： 1+3+5+7+....+(2*n-1)=n^2
 */
public class IsPerfectSquare {
    public static void main(String[] args){
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(14));
    }

    private static boolean isPerfectSquare(int num) {
        if(num <= 0){
            throw new IllegalArgumentException("入参需为正整数");
        }

        // 性质1：完全平方数的末位数只能是0,1,4,5,6,9。
        // 性质2：奇数的平方的个位数字为奇数，十位数字为偶数。
        // 性质3：如果完全平方数的十位数字是奇数，则它的个位数字一定是6；反之，如果完全平方数的个位数字是6，则它的十位数字一定是奇数。
        // 性质4：偶数的平方是4的倍数；奇数的平方是4的倍数加1。
        // 性质5：奇数的平方是8n+1型；偶数的平方为8n或8n+4型。
        // 性质6：平方数的形式必为下列两种之一：3k,3k+1。

        for(int i = 1;num > 0; i += 2)
        {
            num -= i;
        }

        return 0 == num;
    }
}
