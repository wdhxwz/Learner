package com.wangdh.learner.multithread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * @Auther: dw_wanghonghong
 * @Date: 2018/7/2 16:18
 * @Description:
 */
public class CustomeThreadPool {
    /**
     int corePoolSize,
     int maximumPoolSize,
     long keepAliveTime,
     TimeUnit unit,
     BlockingQueue<Runnable> workQueue,
     ThreadFactory threadFactory,
     RejectedExecutionHandler handler
     */
    private static ExecutorService threadPool = Executors.newFixedThreadPool(4);
    private static ExecutorService threadPool2 = new ThreadPoolExecutor(4,4,0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(),
            new CustomerThreadFactory("poolName","threadName"),
            new ThreadPoolExecutor.AbortPolicy());
    private static Logger logger = LoggerFactory.getLogger(CustomeThreadPool.class);

    public static void main(String[] args){
        logger.info("start......");
        for(int index = 0;index < 10;index ++){
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    logger.info("running......");
                }
            });
            threadPool2.submit(new Runnable() {
                @Override
                public void run() {
                    logger.info("running2......");
                }
            });
        }
        logger.info("end......");
    }
}
