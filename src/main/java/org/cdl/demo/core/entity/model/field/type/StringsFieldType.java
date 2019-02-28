package org.cdl.demo.core.entity.model.field.type;

import java.util.HashMap;
import java.util.Map;

import org.cdl.demo.core.entity.model.field.FieldType;
import org.cdl.demo.core.entity.model.field.value.StringFieldValue;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(100)
public class StringsFieldType implements FieldType<StringFieldValue> {

	@Override
	public String getName() {
		return "多字符串";
	}

	@Override
	public String getType() {
		return "strings";
	}

	@Override
	public String getColumnName() {
		return StringFieldValue.COLUMN_NAME;
	}

	@Override
	public String getTemplate() {
		return "/admin/content/field/strings";
	}

	@Override
	public String getOptionTemplate() {
		return "/admin/model/field/option/strings";
	}

	@Override
	public boolean isSingle() {
		return false;
	}

	@Override
	public Map<String, Object> parseOption(Map<String, String> params) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (params.containsKey("maxlength"))
			map.put("maxlength", Integer.valueOf(params.get("maxlength")));
		if (params.containsKey("blankable"))
			map.put("blankable", Boolean.valueOf(params.get("blankable")));
		return map;
	}

}
