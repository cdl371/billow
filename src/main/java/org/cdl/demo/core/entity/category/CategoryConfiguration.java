package org.cdl.demo.core.entity.category;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryConfiguration {

	@Bean
	@Qualifier("categoryMap")
	public Map<String, Category> categoryMap(List<Category> list) {
		Map<String, Category> map = new LinkedHashMap<String, Category>();
		if (list != null) {
			for (Category category : list) {
				map.put(category.getCode(), category);
			}
		}
		return map;
	}

}
