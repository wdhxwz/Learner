package com.wangdh.learner.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class slf4jTest {
	private static Logger logger = LoggerFactory.getLogger(slf4jTest.class);
	
	
	public static void main(String[] args) {
		logger.info("info");

		System.out.println("OK");
	}

}
