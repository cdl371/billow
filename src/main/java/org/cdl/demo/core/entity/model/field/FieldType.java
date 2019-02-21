package org.cdl.demo.core.entity.model.field;

import java.lang.reflect.ParameterizedType;

public interface FieldType<T extends FieldValue<?>> {

	String getName();

	String getType();

	String getTemplate();

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

}
