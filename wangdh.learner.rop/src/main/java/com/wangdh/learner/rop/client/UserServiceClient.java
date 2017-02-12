package com.wangdh.learner.rop.client;

import com.rop.MessageFormat;
import com.rop.client.CompositeResponse;
import com.wangdh.learner.rop.request.LogonRequest;
import com.wangdh.learner.rop.response.LogonResponse;

public class UserServiceClient extends BaseClient {

	public UserServiceClient(String appKey, String appSecret, String serviceUrl) {
		super(appKey, appSecret, serviceUrl, MessageFormat.json);
	}

	public String getSession(String version) {
		String sessionId = "NULL";
		CompositeResponse<?> response =  ropClient.buildClientRequest()
				.get(LogonResponse.class, "user.getSession", version);
		if (response.isSuccessful()) {
			sessionId = ((LogonResponse)response.getSuccessResponse()).getSessionId();
		}else{
			sessionId = response.getErrorResponse().getMessage();
		}

		return sessionId;
	}

	public String login(String userName, String password, String version) {
		LogonRequest logonRequest = new LogonRequest();
		logonRequest.setPassword(password);
		logonRequest.setUserName(userName);

		CompositeResponse<?> response = ropClient.buildClientRequest().get(logonRequest, LogonResponse.class,
				"user.login", version);

		String sessionId = ((LogonResponse) response.getSuccessResponse()).getSessionId();
		ropClient.setSessionId(sessionId);

		return sessionId;
	}

	public String logout(String version) {
		CompositeResponse<?> response = ropClient.buildClientRequest().get(LogonResponse.class, "user.logout", version);
		String sessionId = ((LogonResponse) response.getSuccessResponse()).getSessionId();
		
		return sessionId;
	}
}