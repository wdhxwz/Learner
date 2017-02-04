/**
 * 
 */
package com.wangdh.learner.base.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author wdhcxx
 *
 */
public class Country {

	public static <E> E toJavaBean(Class<E> type,String jsonString)
			throws JsonParseException, JsonMappingException, IOException {
		TypeReference<E> typeReference = new TypeReference<E>() {};
	
		ObjectMapper mapper = new ObjectMapper();
		
		return mapper.readValue(jsonString, typeReference);
	}

	// 注意：被序列化的bean的private属性字段需要创建getter方法或者属性字段应该为public
	private String country_id;
	private Date birthDate;
	private List<String> nation = new ArrayList<String>();
	private String[] lakes;
	private List<Province> provinces = new ArrayList<Province>();
	private Map<String, Integer> traffic = new HashMap<String, Integer>();

	public String getCountry_id() {
		return country_id;
	}

	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<String> getNation() {
		return nation;
	}

	public void setNation(List<String> nation) {
		this.nation = nation;
	}

	public String[] getLakes() {
		return lakes;
	}

	public void setLakes(String[] lakes) {
		this.lakes = lakes;
	}

	public List<Province> getProvinces() {
		return provinces;
	}

	public void setProvinces(List<Province> provinces) {
		this.provinces = provinces;
	}

	public Map<String, Integer> getTraffic() {
		return traffic;
	}

	public void setTraffic(Map<String, Integer> traffic) {
		this.traffic = traffic;
	}
}
