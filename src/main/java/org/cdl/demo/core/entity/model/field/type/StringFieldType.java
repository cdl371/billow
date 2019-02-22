package org.cdl.demo.core.entity.model.field.type;

import java.util.HashMap;
import java.util.Map;

import org.cdl.demo.core.entity.model.field.FieldType;
import org.cdl.demo.core.entity.model.field.value.StringFieldValue;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(100)
public class StringFieldType implements FieldType<StringFieldValue> {

	@Override
	public String getName() {
		return "字符串";
	}

	@Override
	public String getType() {
		return "string";
	}

	@Override
	public String getTemplate() {
		return "/admin/content/field/string";
	}

	@Override
	public String getOptionTemplate() {
		return "/admin/model/field/option/string";
	}

	@Override
	public Map<String, Object> parseOption(Map<String, String[]> params) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (params.containsKey("maxlength"))
			map.put("maxlength", Integer.valueOf(params.get("maxlength")[0]));
		if (params.containsKey("blankable"))
			map.put("blankable", Boolean.valueOf(params.get("blankable")[0]));
		return map;
	}

}
