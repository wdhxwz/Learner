package com.wangdh.learner.base.spi;

public class SpiBImpl implements Spi{

	@Override
	public boolean isSupport(String name) {
		if(name==null) return false;
		
		return "SPIB".equalsIgnoreCase(name.trim());
	}

	@Override
	public String sayHello() {
		return "say hello from B";
	}
}