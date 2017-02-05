package com.wangdh.learner.logger;

import org.apache.log4j.Logger;

public class Log4jTest {
	/**
	 * Log4j日志记录器
	 */
	private static Logger logger = Logger.getLogger(Log4jTest.class);

	public static void main(String[] args) {
		for (int i = 0; i < 220000000; i++) {
			logger.info("info" + i);
		}
		logger.info("info");
	}
}
