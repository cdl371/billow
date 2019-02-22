package org.cdl.demo.core.entity.model.field.type;

import java.util.HashMap;
import java.util.Map;

import org.cdl.demo.core.entity.model.field.FieldType;
import org.cdl.demo.core.entity.model.field.value.IntegerFieldValue;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(200)
public class IntegerFieldType implements FieldType<IntegerFieldValue> {

	@Override
	public String getName() {
		return "整型";
	}

	@Override
	public String getType() {
		return "integer";
	}

	@Override
	public String getTemplate() {
		return "/admin/content/field/integer";
	}

	@Override
	public String getOptionTemplate() {
		return "/admin/model/field/option/integer";
	}

	@Override
	public Map<String, Object> parseOption(Map<String, String[]> params) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (params.containsKey("maxlength"))
			map.put("maxlength", Integer.valueOf(params.get("maxlength")[0]));
		if (params.containsKey("default"))
			map.put("default", Integer.valueOf(params.get("default")[0]));
		return map;
	}

}
