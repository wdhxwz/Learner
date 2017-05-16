package com.wangdh.learner.base.okhttp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.wangdh.learner.base.json.JsonUtils;

import okhttp3.ConnectionPool;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AppTest {

	public static void main(String[] args) throws IOException {
		// OkHttpClient client = new OkHttpClient.Builder().connectTimeout(60,
		// TimeUnit.SECONDS)
		// .readTimeout(60, TimeUnit.SECONDS).writeTimeout(30,
		// TimeUnit.SECONDS).build();
		//
		// // http://tfiles.cmbchinaucs.com/d6bf8869a2724c5cab5e047e94cd354b.png
		//
		// // Content-Type=text/html text
		// // Content-Type=image/png image
		// // Content-Type=text/plain;charset=UTF-8 text
		//
		// Request request = new
		// Request.Builder().url("http://accountcmb.frontpay.cn/common/getSystemInfo.do").build();
		//
		// request = new
		// Request.Builder().url("http://accountcmb.frontpay.cn/common/getSystemInfo.do")
		// .addHeader("headname", "headerValue").build();
		//
		// // post -- String
		// String postBody =
		// "{\"userNo\":\"liumianqian001\",\"customerGroupNo\":\"L000\",\"UserId\":null}";
		// MediaType mediaType =
		// MediaType.parse("application/json;charset=UTF-8");
		// request = new
		// Request.Builder().url("http://accountcmb.frontpay.cn/serviceapi/getCompanyInfo.do")
		// .addHeader("Content-Type",
		// "application/json").post(RequestBody.create(mediaType,
		// postBody)).build();
		//
		// // post -- file
		// File file = new
		// File("C:\\Users\\Administrator\\Desktop\\13413735.jpg");
		// @SuppressWarnings("resource")
		// FileInputStream out = new FileInputStream(file);
		// int length = (int) file.length();
		// byte[] fileBytes = new byte[length];
		// out.read(fileBytes);
		//
		// RequestBody requestBody = new
		// MultipartBody.Builder().setType(MultipartBody.FORM)
		// .addFormDataPart("title", "Square Logo").addFormDataPart("image",
		// "logo-square.png",
		// RequestBody.create(MediaType.parse("image/jpg"), fileBytes))
		// .build();
		// request = new
		// Request.Builder().url("http://accountcmb.frontpay.cn/common/fileupload.do")
		// .addHeader("Content-Type", "application/json")
		// .addHeader("Cookie",
		// "DISCONF=36a53ca0-7cbf-42dd-bb64-03cf7662bbf7;
		// Hm_lvt_dc9a1f3ac867150f27a4aec62e0ec43b=1491875455;
		// SESSION=28bb7b72-575c-4df4-8603-b6c82ff21a29;
		// sso_client_oasbiz_ticket=d34d6871791845a18d4d233ea36bd79frEttRbSV")
		// .post(requestBody).build();
		//
		// try {
		// Response response = client.newCall(request).execute();
		// System.out.println(response.code());
		// System.out.println(response.isSuccessful());
		// // System.out.println(response.message());
		//
		// // Headers headers = response.headers();
		// // for (String header : headers.names()) {
		// // System.out.println(header + "=" + headers.get(header));
		// // }
		//
		// System.out.println(response.header("Content-Type"));
		//
		// System.out.println(response.body().string());
		//
		// System.out.println(response.body().contentType().type());
		//
		// } catch (IOException e) {
		//
		// e.printStackTrace();
		// }

		Map<String, String> postData = new HashMap<String, String>();
		postData.put("userNo", "liumianqian001");
		postData.put("customerGroupNo", "L000");

		String url = "http://accountcmb.frontpay.cn/serviceapi/getCompanyInfo.do";
		ResponseData responseData = post(url, postData, ContentTypeEnum.JSON, CharsetEnum.UTF8, 60, 60);
		System.out.println(responseData.getCode());
		System.out.println(responseData.getData());

		System.out.println("OK");
	}

	public static ResponseData post(String url, Map<String, String> postData, ContentTypeEnum contentType,
			CharsetEnum charset, int connectTimeout, int readTimeout) {
		ResponseData responseData = new ResponseData();

		OkHttpClient client = new OkHttpClient.Builder().connectTimeout(connectTimeout, TimeUnit.SECONDS)
				.connectionPool(new ConnectionPool(200, 60, TimeUnit.SECONDS))
				.readTimeout(readTimeout, TimeUnit.SECONDS).build();

		MediaType mediaType = MediaType.parse(contentType.getValue() + ";" + charset.getValue());

		String postBody = JsonUtils.toJson(postData);
		Request request = new Request.Builder().url(url).addHeader("Content-Type", contentType.getValue())
				.post(RequestBody.create(mediaType, postBody)).build();
		try {
			Response response = client.newCall(request).execute();

			responseData.setCode(response.code());
			responseData.setData(response.body().string());
		} catch (Exception e) {
			System.out.println(e);
		}

		return responseData;
	}

	public static class ResponseData {
		private Object data;
		private int code;

		public Object getData() {
			return data;
		}

		public void setData(Object data) {
			this.data = data;
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}
	}
}
