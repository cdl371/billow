package org.cdl.demo.core.entity.model.field.type;

import java.util.HashMap;
import java.util.Map;

import org.cdl.demo.core.entity.model.field.FieldType;
import org.cdl.demo.core.entity.model.field.value.StringListFieldValue;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(500)
public class StringListFieldType implements FieldType<StringListFieldValue> {

	@Override
	public String getName() {
		return "字符串列表";
	}

	@Override
	public String getType() {
		return "stringlist";
	}

	@Override
	public String getTemplate() {
		return "/admin/content/field/stringlist";
	}

	@Override
	public String getOptionTemplate() {
		return "/admin/model/field/option/stringlist";
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
