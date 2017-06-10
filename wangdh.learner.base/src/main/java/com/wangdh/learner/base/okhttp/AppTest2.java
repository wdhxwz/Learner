package com.wangdh.learner.base.okhttp;

import java.io.IOException;

public class AppTest2 {

	public static void main(String[] args) throws IOException {
		ApiRequest2001 request2001 = new ApiRequest2001();
		RequestHead requestHead = new RequestHead();
		requestHead.setAppNo("RZ01");
		requestHead.setApiNo("Api2002");
		requestHead.setVersion("1.0");
		request2001.setRequestHead(requestHead);
		request2001.setChannelNo("Z001");
		
		String url = "http://127.0.0.1:8080/api";
		
//		String response = HttpUtils.doPost(url, "application/json", JsonUtils.toJson(request2001).getBytes(),
//				10000, 1000);
		String response = HttpUtils.doPostJson(url, request2001, 10000, 10000);
		System.out.println(response);
	}
}
