package com.wangdh.learner.springmvc.service;

import com.wangdh.learner.springmvc.annotation.ServiceBean;
import com.wangdh.learner.springmvc.annotation.ServiceMethod;

@ServiceBean(value = "OAS2012")
public class OAS2012Service {

	@ServiceMethod(method = "getUser", version = "1.0")
	public String getUser() {
		return "user1";
	}

	@ServiceMethod(method = "getUser", version = "1.1")
	public String getUser2() {
		return "user2";
	}
}