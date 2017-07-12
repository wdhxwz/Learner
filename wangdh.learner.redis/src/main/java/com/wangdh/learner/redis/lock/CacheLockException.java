package com.wangdh.learner.redis.lock;

public class CacheLockException extends Throwable{
	private static final long serialVersionUID = 4317750297748583659L;
	private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public CacheLockException(String msg) {
        this.msg = msg;
    }

    public CacheLockException() {
    }
}