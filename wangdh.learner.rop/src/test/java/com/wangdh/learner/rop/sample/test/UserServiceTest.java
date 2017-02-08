package com.wangdh.learner.rop.sample.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.rop.client.CompositeResponse;
import com.rop.client.DefaultRopClient;
import com.rop.client.RopClient;
import com.wangdh.learner.rop.request.LogonRequest;
import com.wangdh.learner.rop.response.LogonResponse;

public class UserServiceTest {
	private static final String SERVER_URL = "http://localhost:8080/wangdh.learner.rop/router";
	private static final String APP_KEY = "00001";
	private static final String APP_SECRET = "abcdeabcdeabcdeabcdeabcde";
	private RopClient ropClient;

	@Before
	public void setUp() {
		ropClient = new DefaultRopClient(SERVER_URL, APP_KEY, APP_SECRET);
	}

	@Test
	public void getSession() {

		// 构造请求对象
		LogonRequest ropRequest = new LogonRequest();
		ropRequest.setUserName("tomson");
		ropRequest.setPassword("123456");

		CompositeResponse<?> response = ropClient.buildClientRequest().get(ropRequest, LogonResponse.class,
				"user.getSession", "1.0");

		assertNotNull(response);
		assertTrue(response.isSuccessful());
		assertNotNull(response.getSuccessResponse());
		assertTrue(response.getSuccessResponse() instanceof LogonResponse);
		assertEquals(((LogonResponse) response.getSuccessResponse()).getSessionId(), "mockSessionId1");
	}

}
