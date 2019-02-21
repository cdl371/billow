package org.cdl.demo.core.entity.model.field.type;

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

}
