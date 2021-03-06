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
	public String getColumnName() {
		return StringFieldValue.COLUMN_NAME;
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
	public boolean isSingle() {
		return true;
	}

	@Override
	public Map<String, Object> parseOption(Map<String, String> options) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (options.containsKey("maxlength")) {
			Integer maxlength = Integer.valueOf(options.get("maxlength"));
			// TODO validate maxlength.....
			map.put("maxlength", maxlength);
		}
		return map;
	}

}
