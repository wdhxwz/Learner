package com.wangdh.learner.rop.manager;

import java.util.HashMap;
import java.util.Map;

import com.rop.security.AppSecretManager;

public class SampleAppSecretManager implements AppSecretManager {

	private static Map<String, String> appKeySecretMap = new HashMap<String, String>();

	static {
		appKeySecretMap.put("00001", "abcdeabcdeabcdeabcdeabcde");
		appKeySecretMap.put("00002", "abcdeabcdeabcdeabcdeaaaaa");
		appKeySecretMap.put("00003", "abcdeabcdeabcdeabcdeaaaaa");
	}

	@Override
	public String getSecret(String appKey) {
		System.out.println("appKey=" + appKey + ",secret=" + appKeySecretMap.get(appKey));
		return appKeySecretMap.get(appKey);
	}

	@Override
	public boolean isValidAppKey(String appKey) {
		return getSecret(appKey) != null;
	}

}
