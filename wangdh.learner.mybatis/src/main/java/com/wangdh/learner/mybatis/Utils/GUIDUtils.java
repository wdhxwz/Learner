package com.wangdh.learner.mybatis.Utils;

import java.util.UUID;

public class GUIDUtils {
	public static String guid() {
		return UUID.randomUUID().toString();
	}

	public static String guid(String replace) {
		return guid().replaceAll("-", "");
	}
}
