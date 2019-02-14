package org.cdl.demo.core.entity.model.field.type;

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
	public String getCode() {
		return "text";
	}

}
