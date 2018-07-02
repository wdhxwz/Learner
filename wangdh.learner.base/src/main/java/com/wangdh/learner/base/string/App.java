package com.wangdh.learner.base.string;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: dw_wanghonghong
 * @Date: 2018/6/27 18:05
 * @Description:
 */
public class App {
    public static void main(String[] args){
        String str = "20180601";
        System.out.println(str.substring(0,6));

        List list = Arrays.asList("201805","201804","201803");
        System.out.println(list.toString());
    }
}
