package org.cdl.demo.core.entity.model.field.type;

import java.util.HashMap;
import java.util.Map;

import org.cdl.demo.core.entity.model.field.FieldType;
import org.cdl.demo.core.entity.model.field.value.TextFieldValue;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(400)
public class TextFieldType implements FieldType<TextFieldValue> {

	@Override
	public String getName() {
		return "文本";
	}

	@Override
	public String getType() {
		return "text";
	}

	@Override
	public String getTemplate() {
		return "/admin/content/field/text";
	}

	@Override
	public String getOptionTemplate() {
		return "/admin/model/field/option/text";
	}

	@Override
	public boolean isSingle() {
		return true;
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
