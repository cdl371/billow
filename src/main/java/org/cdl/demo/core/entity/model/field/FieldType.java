package org.cdl.demo.core.entity.model.field;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.cdl.demo.core.entity.content.Content;

public interface FieldType<T extends FieldValue<?>> {

	String getName();

	String getType();

	String getColumnName();

	boolean isSingle();

	String getTemplate();

	String getOptionTemplate();

	Map<String, Object> parseOption(Map<String, String> options);

	default Map<String, Object> parseOptionMap(Field field) {
		if (field != null) {
			Map<String, String> options = field.getOptions();
			if (options != null && !options.isEmpty()) {
				Map<String, Object> map = parseOption(options);
				if (map != null) {
					return map;
				}
			}
		}
		return new HashMap<String, Object>();
	}

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

}
