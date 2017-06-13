package com.wangdh.learner.base.okhttp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.wangdh.learner.base.json.JsonUtils;

public class AppTest2 {

	public static void main(String[] args) throws IOException {
		ApiRequest2001 request2001 = new ApiRequest2001();
		RequestHead requestHead = new RequestHead();
		requestHead.setAppKey("RZ01");
		requestHead.setApiNo("Api2001");
		requestHead.setVersion("1.0");
		request2001.setRequestHead(requestHead);
		request2001.setChannelNo("Z001");
		request2001.setName("123");
		
		Map<String, String> map = new HashMap<>();
		map.put("appKey", "Z001");
		
		String url = "http://127.0.0.1:8080/api";
		
//		String response = HttpUtils.doPost(url, "application/json", JsonUtils.toJson(null).getBytes(),
//				10000, 1000);
//		System.out.println(response);
//		System.out.println(HttpUtils.doPostJson(url,"", 10000, 10000));
//		System.out.println(HttpUtils.doPostJson(url,"123", 10000, 10000));
//		System.out.println(HttpUtils.doPostJson(url,map, 10000, 10000));
		System.out.println(HttpUtils.doPostJson(url,request2001, 10000, 10000));
		
//		System.out.println("");
//		System.out.println(JsonUtils.toJson(""));
	}
}