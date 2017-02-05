package com.wangdh.learner.logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CommonLoggingTest {
	private static Log log = LogFactory.getLog(CommonLoggingTest.class);
	
	
	@SuppressWarnings("null")
	public static void main(String[] args) {
		log.trace("trace");
		log.debug("debug");
		log.info("info");
		log.warn("warn");
		log.error("error");
		log.fatal("fatal");
		
		try{
			String string =null;
			string.length();
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
		}
	}

}
