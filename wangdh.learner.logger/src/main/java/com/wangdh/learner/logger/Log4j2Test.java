package com.wangdh.learner.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * log4j 2.x
 * 
 * @author wdhcxx
 *
 */
public class Log4j2Test {
	private static final Logger LOGGER =  LogManager.getLogger(Log4j2Test.class);

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 2000000; i++) {
			sb.append("a");
		}
		
		String s = sb.toString();
		long currentTime = System.currentTimeMillis();
		LOGGER.info("时间1：{}", s);
		LOGGER.info("时间2：{}", (System.currentTimeMillis() - currentTime) / 1000);
		
		System.out.println(System.currentTimeMillis() - currentTime);
	}
}