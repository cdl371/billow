package org.cdl.demo.core.entity.model.field;

import java.lang.reflect.ParameterizedType;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.cdl.demo.core.entity.content.Content;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

@Component
public class FieldTypeConfiguration extends LinkedHashMap<String, FieldType<?>> {

	private static final long serialVersionUID = 1L;

	public FieldTypeConfiguration(ObjectProvider<FieldType<?>> provider) {
		List<FieldType<?>> fieldTypes = provider.orderedStream().collect(Collectors.toList());
		if (fieldTypes != null) {
			for (FieldType<?> fieldType : fieldTypes) {
				this.put(fieldType.getCode(), fieldType);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public FieldValue createFieldValue(Content content, Field field) {
		try {
			FieldValue fieldValue = (FieldValue) ((Class<FieldValue>) ((ParameterizedType) this.get(field.getCode())
					.getClass().getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
			fieldValue.setContent(content);
			fieldValue.setField(field);
			return fieldValue;
		} catch (InstantiationException | IllegalAccessException e) {
		}
		return null;
	}

}
