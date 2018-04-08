package com.wangdh.learner.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试String常量池的位置
 * <br/> JVM参数：-Xmx5m -XX:MaxPermSize=5m
 * </br/> 1.7及以上，抛出 java.lang.OutOfMemoryError: Java heap space,证明常量池在堆中
 */
public class StringInternOOM {
    public static void main(String[] args){
        // 以下代码测试String常量池所在的区域
        // 异常抛出的区域，即为常量所在内存区
//        List<String> list = new ArrayList<>();
//        int i = 0;
//        while (true){
//            list.add(String.valueOf(i++).intern());
//        }

    }
}
