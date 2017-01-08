/**
 * 
 */
package com.wangdh.learner.base.json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;

/**
 * @author wdhcxx
 *
 */
public class JsonGeneratorTest {

	private final static String JSON_FILE = "wangdh.json";

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// 声明一个jsonFactory实例
		JsonFactory jsonFactory = new JsonFactory();
		jsonFactory.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, false);

		// 构造一个json生成器，指定文件名和编码方式
		JsonGenerator jsonGenerator = jsonFactory.createGenerator(new File(JSON_FILE), JsonEncoding.UTF8);

		// 开始构造json对象，相当于在最前面加上"{"
		jsonGenerator.writeStartObject();

		// 开始编写属性,必须配对，一个writeFieldName()开始，紧接着一个writeXXX()方法写值
		jsonGenerator.writeFieldName("name");
		jsonGenerator.writeString("wangdh");

		jsonGenerator.writeFieldName("isMan");
		jsonGenerator.writeBoolean(true);

		jsonGenerator.writeFieldName("age");
		jsonGenerator.writeNumber("25");

		jsonGenerator.writeFieldName("fruit");

		// 开始写数值，相当于"["
		jsonGenerator.writeStartArray();
		jsonGenerator.writeString("apple");
		jsonGenerator.writeString("orange");

		// 结束写数组，相当于"]"
		jsonGenerator.writeEndArray();

		// 每次写一个属性
		jsonGenerator.writeStringField("sex", "man");
		jsonGenerator.writeNumberField("degree", 25);
		jsonGenerator.writeBooleanField("hasLover", true);
		
		// 写数组
		jsonGenerator.writeArrayFieldStart("array");
		jsonGenerator.writeString("apple");
		jsonGenerator.writeString("orange");
		jsonGenerator.writeEndArray();

		// 介绍json对象构造，相当于在末尾加"}"
		jsonGenerator.writeEndObject();

		// 释放jsonGenerator资源
		jsonGenerator.close();

		System.out.println("OK");
	}

}
