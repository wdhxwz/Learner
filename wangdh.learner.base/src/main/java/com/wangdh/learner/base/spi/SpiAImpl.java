package com.wangdh.learner.base.spi;

public class SpiAImpl implements Spi{

	@Override
	public boolean isSupport(String name) {
		if(name==null) return false;
		
		return "SPIA".equalsIgnoreCase(name.trim());
	}

	@Override
	public String sayHello() {
		return "say hello from A";
	}
}