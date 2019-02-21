package org.cdl.demo.core.entity.model.field;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FieldTypeConfiguration {

	@Bean
	@Qualifier("fieldTypeMap")
	public Map<String, FieldType<?>> fieldTypeMap(List<FieldType<?>> list) {
		Map<String, FieldType<?>> map = new LinkedHashMap<String, FieldType<?>>();
		if (list != null) {
			for (FieldType<?> fieldType : list) {
				map.put(fieldType.getType(), fieldType);
			}
		}
		return map;
	}

}
