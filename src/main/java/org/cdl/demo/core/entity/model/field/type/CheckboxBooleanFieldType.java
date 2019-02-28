package org.cdl.demo.core.entity.model.field.type;

import java.util.HashMap;
import java.util.Map;

import org.cdl.demo.core.entity.model.field.FieldType;
import org.cdl.demo.core.entity.model.field.value.BooleanFieldValue;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(300)
public class CheckboxBooleanFieldType implements FieldType<BooleanFieldValue> {

	@Override
	public String getName() {
		return "布尔复选框";
	}

	@Override
	public String getType() {
		return "checkboxBoolean";
	}

	@Override
	public String getColumnName() {
		return BooleanFieldValue.COLUMN_NAME;
	}

	@Override
	public String getTemplate() {
		return "/admin/content/field/checkbox_boolean";
	}

	@Override
	public String getOptionTemplate() {
		return "/admin/model/field/option/checkbox_boolean";
	}

	@Override
	public boolean isSingle() {
		return true;
	}

	@Override
	public Map<String, Object> parseOption(Map<String, String> options) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (options.containsKey("label")) {
			String label = options.get("label");
			// TODO validate label.....
			map.put("label", label);
		}
		if (options.containsKey("default")) {
			Boolean _default = Boolean.valueOf(options.get("default"));
			// TODO validate default.....
			map.put("default", _default);
		}
		return map;
	}

}
