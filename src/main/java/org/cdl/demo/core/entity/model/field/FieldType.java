package org.cdl.demo.core.entity.model.field;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface FieldType<T extends FieldValue<?>> {

	String getName();

	String getType();

	String getTemplate();

	String getOptionTemplate();

	Map<String, Object> parseOption(Map<String, String[]> params);

	@SuppressWarnings("unchecked")
	default Class<T> getFieldValueType() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
	}

	default T createFieldValue() {
		T fieldValue = null;
		try {
			fieldValue = getFieldValueType().newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
		}
		return fieldValue;
	}

	default String parseOptionString(Map<String, String[]> params) {
		Map<String, Object> option = parseOption(params);
		try {
			return new ObjectMapper().writeValueAsString(option);
		} catch (JsonProcessingException e) {
			return null;
		}
	}

	default Map<String, Object> parseOptionMap(String optionString) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = new ObjectMapper().readValue(optionString, new TypeReference<Map<String, Object>>() {
			});
		} catch (IOException e) {
		}
		return map;
	}

}
