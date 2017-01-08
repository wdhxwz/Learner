/**
 * 
 */
package com.wangdh.learner.base.json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author wdhcxx
 *
 */
public class JsonTreeTest {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		JsonFactory jsonFactory = new JsonFactory();
		JsonNodeFactory jsonNodeFactory = new JsonNodeFactory(false);
		ObjectMapper objectMapper = new ObjectMapper();

		JsonGenerator jsonGenerator = jsonFactory.createGenerator(new File("jsonTree.json"), JsonEncoding.UTF8);

		ObjectNode objectNode = jsonNodeFactory.objectNode();
		objectNode.put("name", "wangdh");

		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		objectMapper.writeTree(jsonGenerator, objectNode);
	}
}
