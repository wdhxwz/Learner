package com.wangdh.learner.rop.test;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.rop.utils.RopUtils;

// import com.rop.utils.RopUtils;

public class UserServiceTest1 {    

	private static final String SERVER_URL = "http://localhost:8082/wangdh.learner.rop/router";
	private static final String APP_KEY = "00001";
	private static final String APP_SECRET = "abcdeabcdeabcdeabcdeabcde";

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
		form.add("method", "user.getSession");
		form.add("appKey", APP_KEY);
		form.add("appSecret", APP_SECRET);
		form.add("v", "1.0");
		form.add("format", "json");
		form.add("userName", "tomson");
		form.add("password", "123456");

		// 对请求参数列表进行签名
		String sign = RopUtils.sign(form.toSingleValueMap(), APP_SECRET);
		form.add("sign", sign);
		String response = restTemplate.postForObject(SERVER_URL, form, String.class);

		System.out.println(response);
	}
}
