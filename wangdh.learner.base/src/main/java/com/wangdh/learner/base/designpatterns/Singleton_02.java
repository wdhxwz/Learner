package com.wangdh.learner.base.designpatterns;

/**
 * @author wangdh
 * @Description
 * @date 2018-02-01
 */
public class Singleton_02 {
    /**
     * 私有化构造函数
     */
    private Singleton_02(){

    }

    /**
     * 存放单例对象的引用
     */
    private static  Singleton_02 instance;

    /**
     * 将单例实例返回给调用者
     * @return
     */
    public static Singleton_02 getInstance(){
        if(instance == null){
            synchronized (Singleton_02.class){
                if(instance == null){
                    instance = new Singleton_02();
                }
            }
        }

        return  instance;
    }
}
