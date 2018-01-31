package com.wangdh.learner.base.thread;

/**
 * @author wangdh
 * @Description
 * @date 2018-01-31
 */
public class VolatileDemo {
    public static void main(String[] args) {
        VolatileThread volatileThread = new VolatileThread();
        Thread thread = new Thread(volatileThread);
        thread.start();
        try {
            System.out.println(thread.getId());
            Thread.sleep(2);
        } catch (Exception ex) {

        }
        volatileThread.shutdown();
    }
}

class VolatileThread implements Runnable {
    private volatile boolean shutdown = false;

    public void shutdown() {
        shutdown = true;
    }

    @Override
    public void run() {
        while (!shutdown) {
            System.out.println("我还在运行...");
        }
    }
}
