package com.wangdh.learner.base.designpatterns;

/**
 * @author wangdh
 * @Description
 * @date 2018-02-01
 */
public class Singleton {
    /**
     * 存放单例对象的引用
     */
    private static Singleton instance = new Singleton();

    /**
     * 构造函数私有化
     */
    private Singleton(){

    }

    /**
     * 将单例实例返回给调用者
     * @return
     */
    public static  Singleton getInstance(){
        return instance;
    }
}