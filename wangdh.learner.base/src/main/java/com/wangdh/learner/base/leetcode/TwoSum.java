package com.wangdh.learner.base.leetcode;

import java.util.Arrays;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。<br/>
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。<br/>
 * 思路：
 * 1.给定的目标值，大于数组中最大的两个数之和
 * 2.将数组排序
 */
public class TwoSum {
    public static void main(String[] args){
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 17;

        int[] result = twoSum(nums,target);
        if(result != null){
            System.out.println(result[0]+"," + result[1]);
        }else{
            System.out.println("没有匹配到");
        }
    }

    private static int[] twoSum(int[] source,int target){
        if(source == null){
            return null;
        }

        int length = source.length;
        if(length < 2){
            return null;
        }

        // 先排序：从小到大
        Arrays.sort(source);

        // 最大的两个数之和都比目标数小
        int maxTwo = source[length-1] + source[length -2];
        if(target > maxTwo){
            return null;
        }

        int[] result = new int[2];

        // 两层循环，如果是3个数之和呢，是否三层循环？
        for(int i = 0; i< length -1 ;i++){
            for (int j = i + 1;j<length ;j++){
                if((source[i] + source[j]) == target){
                    result[0] = i;
                    result[1] = j;

                    return  result;
                }
            }
        }

        return null;
    }
}
