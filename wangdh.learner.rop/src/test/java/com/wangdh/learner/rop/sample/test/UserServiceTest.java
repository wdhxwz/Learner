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
	private static final String SERVER_URL = "http://localhost:8090/router";
	private static final String APP_KEY = "00001";
	private static final String APP_SECRET = "abcdeabcdeabcdeabcdeabcde";
	private static RopClient ropClient;

}
