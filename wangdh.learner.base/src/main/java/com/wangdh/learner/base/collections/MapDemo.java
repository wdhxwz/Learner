package com.wangdh.learner.base.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: dw_wanghonghong
 * @Date: 2018/9/30 15:50
 * @Description:
 */
public class MapDemo {
    private static final long UPPER_LIMIT_TIME = 2 * 60 * 60 * 1000L;// 2小时(毫秒数)
    private static final int UPPER_LIMIT_COUNT = 10;// 10条

    protected Map<Long, String> upperLimitMap = new HashMap<>();



    public static void main(String[] args){
        MapDemo mapDemo = new MapDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    mapDemo.add("" + System.currentTimeMillis());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    mapDemo.isUpperLimit();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public boolean add(String message) {
        long time = System.currentTimeMillis();
        upperLimitMap.put(time, message);
        return true;
    }

//    Exception in thread "Thread-1" java.util.ConcurrentModificationException
//    at java.util.HashMap$HashIterator.nextNode(HashMap.java:1437)
//    at java.util.HashMap$KeyIterator.next(HashMap.java:1461)
//    at com.wangdh.learner.base.collections.MapDemo.isUpperLimit(MapDemo.java:63)
//    at com.wangdh.learner.base.collections.MapDemo$2.run(MapDemo.java:41)
//    at java.lang.Thread.run(Thread.java:745)

    protected boolean isUpperLimit() {
        Set<Long> keySet = upperLimitMap.keySet();
        long limitTime = System.currentTimeMillis() - UPPER_LIMIT_TIME;

        int count = 0;
        for (Long time : keySet) {
            if (time > limitTime) {
                count++;
            }
        }
        return count >= UPPER_LIMIT_COUNT;
    }
}
