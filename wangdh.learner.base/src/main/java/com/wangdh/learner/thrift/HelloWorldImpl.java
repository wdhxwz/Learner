package com.wangdh.learner.thrift;

import org.apache.thrift.TException;

public class HelloWorldImpl implements Hello.Iface{
    @Override
    public String sayHello(String para) throws TException {
        return "Hello " + para + ", Time:" + System.currentTimeMillis();
    }
}
