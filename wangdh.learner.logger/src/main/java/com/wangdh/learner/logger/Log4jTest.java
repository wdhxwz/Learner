package com.wangdh.learner.logger;

import org.apache.log4j.Logger;

// import org.apache.log4j.Logger;

/**
 * log4j 1.x
 * @author wdhcxx
 */
public class Log4jTest {
	/**
	 * Log4j日志记录器
	 */
	// private static Logger logger = Logger.getLogger(Log4jTest.class);
	
	private static Logger logger = Logger.getLogger("com.wangdh.learner.logger.Log4jTest");  

	public static void main(String[] args) {

		logger.info("sbsbsb");
		
//		for (int i = 0; i < 220000000; i++) {
//			logger.info("info" + i);
//		}
//		logger.info("info");
		
		System.out.println("OK");
	}
}
