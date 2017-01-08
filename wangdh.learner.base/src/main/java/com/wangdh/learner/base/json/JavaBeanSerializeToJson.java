/**
 * 
 */
package com.wangdh.learner.base.json;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerationException;
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
		
		System.out.println(mapper.writeValueAsString(country));
		
		System.out.println("OK");
	}
}
