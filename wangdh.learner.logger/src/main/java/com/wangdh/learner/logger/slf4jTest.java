package com.wangdh.learner.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.UUID;

public class slf4jTest {
	private static Logger logger = LoggerFactory.getLogger(slf4jTest.class);
	
	
	public static void main(String[] args) {
		MDC.put("mdc_trace_id",UUID.randomUUID().toString());

		logger.info("info1");
		logger.info("info2");
		logger.info("info3");

		System.out.println("OK");
	}

}
