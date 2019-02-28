package org.cdl.demo.core.entity.model.field.type;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.cdl.demo.core.entity.model.field.FieldType;
import org.cdl.demo.core.entity.model.field.value.StringFieldValue;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

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
	public String getColumnName() {
		return StringFieldValue.COLUMN_NAME;
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
	public Map<String, Object> parseOption(Map<String, String> options) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (options.containsKey("values") && options.containsKey("labels")) {
			Map<String, String> valueMap = new LinkedHashMap<String, String>();
			String[] values = StringUtils.stripAll(StringUtils.split(options.get("values").trim(), ","), null);
			String[] labels = StringUtils.stripAll(StringUtils.split(options.get("labels").trim(), ","), null);
			// TODO validate values and labels.....
			if (values.length == labels.length) {
				for (int i = 0; i < values.length; i++) {
					valueMap.put(values[i], labels[i]);
				}
			}
			map.put("valueMap", valueMap);
		}
		if (options.containsKey("defaults")) {
			String[] defaults = StringUtils.stripAll(StringUtils.split(options.get("defaults").trim(), ","), null);
			// TODO validate defaults.....
			map.put("defaults", defaults);
		}
		return map;
	}

}
