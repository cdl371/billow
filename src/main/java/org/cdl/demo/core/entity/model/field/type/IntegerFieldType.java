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
	public String getColumnName() {
		return IntegerFieldValue.COLUMN_NAME;
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
	public boolean isSingle() {
		return true;
	}

	@Override
	public Map<String, Object> parseOption(Map<String, String> options) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (options.containsKey("max")) {
			Integer max = Integer.valueOf(options.get("max"));
			// TODO validate max.....
			map.put("max", max);
		}
		if (options.containsKey("min")) {
			Integer min = Integer.valueOf(options.get("min"));
			// TODO validate min.....
			map.put("max", min);
		}
		if (options.containsKey("default")) {
			Integer _default = Integer.valueOf(options.get("default"));
			// TODO validate default.....
			map.put("default", _default);
		}
		return map;
	}

}
