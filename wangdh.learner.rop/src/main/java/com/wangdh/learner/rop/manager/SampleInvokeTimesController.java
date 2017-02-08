package com.wangdh.learner.rop.manager;

import java.util.HashMap;
import java.util.Map;

import com.rop.security.InvokeTimesController;
import com.rop.session.Session;

public class SampleInvokeTimesController implements InvokeTimesController {

	private static Map<String, Integer> appCallLimits = new HashMap<String, Integer>();
	private static Map<String, Integer> appCallCounter = new HashMap<String, Integer>();
	static {
		appCallLimits.put("00002", 10);
	}

	@Override
	public void caculateInvokeTimes(String appKey, Session session) {
		if (!appCallCounter.containsKey(appKey)) {
			appCallCounter.put(appKey, 0);
		}
		appCallCounter.put(appKey, appCallCounter.get(appKey) + 1);
	}

	@Override
	public boolean isUserInvokeLimitExceed(String appKey, Session session) {
		 return false;
	}

	@Override
	public boolean isSessionInvokeLimitExceed(String appKey, String sessionId) {
		  return false;
	}

	@Override
	public boolean isAppInvokeLimitExceed(String appKey) {
		 return appCallLimits.containsKey(appKey) &&
	                appCallCounter.get(appKey) > appCallLimits.get(appKey) ;
	}

	@Override
	public boolean isAppInvokeFrequencyExceed(String appKey) {
		return false;
	}

}
