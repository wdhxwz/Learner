/**
 * 
 */
package com.wangdh.learner.base.json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/**
 * @author wdhcxx
 *
 */
public class JsonParserTest {
	private final static String JSON_FILE = "wangdh.json";

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// 实例化一个jsonFactory对象
		JsonFactory jsonFactory = new JsonFactory();
		jsonFactory.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);

		// 构造jsonParser对象
		JsonParser jsonParser = jsonFactory.createParser(new File(JSON_FILE));
		while (!jsonParser.isClosed()) {
			// {，}，[,],key,value都是单独一个JsonToken
			JsonToken jsonToken = jsonParser.nextToken();
			if (jsonToken == null) {
				break;
			}

			// 判断该jsonToken是否是对象的标识符
			if (jsonToken.equals(JsonToken.START_OBJECT) || jsonToken.equals(JsonToken.END_OBJECT)
					|| jsonToken.equals(JsonToken.START_ARRAY) || jsonToken.equals(JsonToken.END_ARRAY)) {
				continue;
			}

			// 解析key和value
			if (jsonToken.equals(JsonToken.FIELD_NAME)) {
				System.out.print("key=" + jsonParser.getText());
			} else {
				System.out.println(";value=" + jsonParser.getText());
			}
		}

		System.out.println("OK");
	}

}
