package com.wangdh.learner.dubbo.provider;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import com.wangdh.learner.dubbo.api.ISampleService;

@Service(version = "0.1.0")
public class SampleService implements ISampleService {

	@Override
	public String sayHello(String name) {
		System.out.println("[" + new SimpleDateFormat("HH:mm:ss.sss").format(new Date()) + "] Hello " + name
				+ ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
		return "Hello " + name + ", response form provider: " + RpcContext.getContext().getLocalAddress();
	}

	@Override
	public void test() {
		System.out.println("[" + new SimpleDateFormat("HH:mm:ss.sss").format(new Date()) + "]");
	}
}
