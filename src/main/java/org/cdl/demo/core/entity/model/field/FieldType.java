package org.cdl.demo.core.entity.model.field;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.cdl.demo.core.entity.content.Content;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface FieldType<T extends FieldValue<?>> {

	String getName();

	String getType();

	String getTemplate();

	String getOptionTemplate();

	boolean isSingle();

	Map<String, Object> parseOption(Map<String, String> params);

	@SuppressWarnings("unchecked")
	default Class<T> getFieldValueType() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
	}

	default List<FieldValue<?>> createFieldValues(Content content, String code, String[] value) {
		List<FieldValue<?>> fieldValues = new ArrayList<FieldValue<?>>();
		try {
			if (value != null && value.length > 0) {
				for (int i = 0; i < (this.isSingle() ? 1 : value.length); i++) {
					if (StringUtils.isNotBlank(value[i])) {
						T fieldValue = getFieldValueType().newInstance();
						fieldValue.setContent(content);
						fieldValue.setCode(code);
						fieldValue.setStringValue(value[i].trim());
						fieldValues.add(fieldValue);
					}
				}
			}
		} catch (InstantiationException | IllegalAccessException e) {
		}
		return fieldValues;
	}

	default String parseOptionString(Map<String, String> params) {
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
		} catch (Exception e) {
		}
		return map;
	}

	default Map<String, Object> parseOptionMap(Field field) {
		return parseOptionMap(field.getOption());
	}

}
