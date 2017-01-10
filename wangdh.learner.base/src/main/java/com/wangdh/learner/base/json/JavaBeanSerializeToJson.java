/**
 * 
 */
package com.wangdh.learner.base.json;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author wdhcxx
 *
 */
public class JavaBeanSerializeToJson {
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		// 使用objectMapper将对象转为json
		ObjectMapper mapper = new ObjectMapper();

		// 格式化时间
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		mapper.setDateFormat(dateFormat);

		Country country = new Country();
		country.setBirthDate(new Date());
		country.setCountry_id("13");

		// 该配置会格式化json数据
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

		// 设置mapper忽略空属性
		mapper.setSerializationInclusion(Include.NON_EMPTY);

		// 默认情况下，jackson会使用java属性名称字段作为json的属性名称
		// 可以使用jackson 注解改变json属性的名称
		mapper.writeValue(new File("objectMapper.json"), country);

		Response<Province> response = new Response<Province>();
		Province province = new Province();
		province.name = "广东省";
		province.population = 1000;
		province.city = new String[] { "广州市", "深圳市", "珠海市" };
		response.setData(province);
		response.setSessionId(UUID.randomUUID().toString());

		String jsonString = mapper.writeValueAsString(response);
		String provinceJson = mapper.writeValueAsString(province);
		// 序列化泛型
		TypeReference<Province> typeReference2 = new TypeReference<Province>() {
		};
		Province p = Country.toJavaBean(provinceJson);
		System.out.println(p.name);
		System.out.println(jsonString);

		// 序列化泛型
		TypeReference<Response<Province>> typeReference = new TypeReference<Response<Province>>() {
		};
		Response<Province> object = mapper.readValue(jsonString, typeReference);
		System.out.println(object.getSessionId());

		System.out.println(mapper.writeValueAsString(country));
		System.out.println("OK");
	}

}
