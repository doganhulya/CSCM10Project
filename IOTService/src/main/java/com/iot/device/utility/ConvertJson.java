package com.iot.device.utility;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class ConvertJson<T> {
	
	T model;
	
	private ObjectMapper mapper;
	
	static Logger logger = Logger.getLogger(ConvertJson.class);
	
	public ConvertJson() {
		
		setMapper(new ObjectMapper());
		getMapper().enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		getMapper().setSerializationInclusion(Include.NON_NULL);
	}
	
	public String convertToJson(Object obj) {
		String result = "";
		try {
			result = getMapper().writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			logger.error("ConvertJson.java --> convertToJson() - error: "+e.getMessage());
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	@SuppressWarnings("unchecked")
	public T parser(String json, Class<?> cls) throws IOException, InstantiationException, IllegalAccessException {

		setModel((T) cls.newInstance());
		setModel((T) getMapper().readValue(json, cls));

		return getModel();

	}// End parser method
	
}
