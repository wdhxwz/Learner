package com.wangdh.learner.base.okhttp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppTest2 {

	public static void main(String[] args) throws IOException {
		ApiRequest2001 request2001 = new ApiRequest2001();
		RequestHead requestHead = new RequestHead();
		requestHead.setAppKey("RZ01");
		requestHead.setApiNo("B004");
		requestHead.setVersion("1.0");
		request2001.setRequestHead(requestHead);
		request2001.setChannelNo("Z001");
		request2001.setName("123");
		
		List<String> apiNos = new ArrayList<>();
		apiNos.add("test01");
	// 	apiNos.add("R001");
//		apiNos.add("R002");
//		apiNos.add("C001");
//		apiNos.add("U001");
//		apiNos.add("U002");
//		apiNos.add("U003");
//		apiNos.add("U004");
//		apiNos.add("U005");
//		apiNos.add("U006");
//		apiNos.add("U007");
//		apiNos.add("B001");
//		apiNos.add("B002");
//		apiNos.add("B003");
//		apiNos.add("B004");
		
		Map<String, String> map = new HashMap<>();
		map.put("appKey", "Z001");
		
		String url = "http://127.0.0.1:8080/api";
		//String url = "http://10.1.21.77:8080/api";
		
//		String response = HttpUtils.doPost(url, "application/json", JsonUtils.toJson(null).getBytes(),
//				10000, 1000);
//		System.out.println(response);
//		System.out.println(HttpUtils.doPostJson(url,"", 10000, 10000));
//		System.out.println(HttpUtils.doPostJson(url,"123", 10000, 10000));
//		System.out.println(HttpUtils.doPostJson(url,map, 10000, 10000));
		
		for (String apiNo : apiNos) {
			requestHead.setApiNo(apiNo);
			request2001.setRequestHead(requestHead);
			System.out.println(HttpUtils.doPostJson(url,request2001, 10000, 10000));
		}
		
		
//		System.out.println("");
//		System.out.println(JsonUtils.toJson(""));
	}
}