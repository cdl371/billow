package org.cdl.demo.core.entity.model.field.type;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.cdl.demo.core.entity.model.field.FieldType;
import org.cdl.demo.core.entity.model.field.value.StringFieldValue;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Order(600)
public class CheckboxStringsFieldType implements FieldType<StringFieldValue> {

	@Override
	public String getName() {
		return "多字符串复选框";
	}

	@Override
	public String getType() {
		return "checkboxStrings";
	}

	@Override
	public String getTemplate() {
		return "/admin/content/field/checkbox_strings";
	}

	@Override
	public String getOptionTemplate() {
		return "/admin/model/field/option/checkbox_strings";
	}

	@Override
	public boolean isSingle() {
		return false;
	}

	@Override
	public Map<String, Object> parseOption(Map<String, String> params) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (params.containsKey("options")) {
				Map<String, String> options = new ObjectMapper().readValue(params.get("options"),
						new TypeReference<Map<String, String>>() {
						});
				// TODO validate options.....
				map.put("options", new ObjectMapper().writeValueAsString(options));
			}
			if (params.containsKey("defaults")) {
				String[] defaults = StringUtils.stripAll(StringUtils.split(params.get("defaults").trim(), ","), null);
				// TODO validate defaults.....
				map.put("defaults", StringUtils.join(defaults, ","));
			}
		} catch (IOException e) {
			throw new RuntimeException("parsing checkboxstrings option failed.");
		}
		return map;
	}

}
