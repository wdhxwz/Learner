/**
 * 
 */
package com.wangdh.learner.base.json;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author wdhcxx
 * http://blog.csdn.net/xiong9999/article/details/53170331
 */
public class JsonDeserializeToJavaBean {

	/**
	 * @param args
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		File json = new File("objectMapper.json");

		// 禁用未知属性打断反序列化功能
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

		// 格式化时间
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		mapper.setDateFormat(dateFormat);

		Country country = mapper.readValue(json, Country.class);
		System.out.println(country.getCountry_id());
		System.out.println(dateFormat.format(country.getBirthDate()));
		System.out.println("OK");
	}

}
