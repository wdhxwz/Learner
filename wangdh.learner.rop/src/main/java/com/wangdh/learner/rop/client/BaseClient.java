package com.wangdh.learner.rop.client;

import com.rop.MessageFormat;
import com.rop.client.DefaultRopClient;
import com.rop.client.RopClient;

public abstract class BaseClient {
	protected String appKey;
	protected String appSecret;
	protected String serviceUrl;
	protected RopClient ropClient;

	protected BaseClient(String appKey, String appSecret, String serviceUrl,MessageFormat format) {
		this.appKey = appKey;
		this.serviceUrl = serviceUrl;
		this.appSecret = appSecret;
		ropClient = new DefaultRopClient(serviceUrl, appKey, appSecret,format);
	}
}