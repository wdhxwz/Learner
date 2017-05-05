package com.wangdh.learner.base.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class PropertiesUtils {

	/**
	 * 将properties文件解析成map
	 * 
	 * @param fileName
	 *            properties文件名称
	 * @return
	 * @throws IOException
	 */
	public static Map<String, String> getConfigMap(String fileName) throws IOException {
		Map<String, String> configData = new HashMap<String, String>();
		InputStream in;
		Properties properties = new Properties();
		in = PropertiesUtils.class.getClassLoader().getResourceAsStream(fileName);
		properties.load(in);

		// 解析并记录配置信息
		if (properties != null && !properties.isEmpty()) {
			for (Entry<Object, Object> entry : properties.entrySet()) {
				String key = entry.getKey().toString();
				String value = entry.getValue().toString();
				if (!configData.containsKey(key)) {
					configData.put(key, value);
				}
			}
		}

		return configData;
	}
}
