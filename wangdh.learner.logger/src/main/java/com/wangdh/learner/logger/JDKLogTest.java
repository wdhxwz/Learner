package com.wangdh.learner.logger;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDKLogTest {
	/**
	 * JDK Logger记录器
	 */
	private static Logger logger = Logger.getLogger(JDKLogTest.class.toString());
	
	static{
		Handler console = new ConsoleHandler();
		console.setLevel(Level.FINE);
		logger.addHandler(console);
	}
	
	public static void main(String[] args) {
		logger.info("info");
		logger.warning("warning");
		logger.finest("finest");
	}
}
