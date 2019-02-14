package org.cdl.demo.core.entity.model.field.type;

import org.cdl.demo.core.entity.model.field.FieldType;
import org.cdl.demo.core.entity.model.field.value.BooleanFieldValue;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(300)
public class BooleanFieldType implements FieldType<BooleanFieldValue> {

	@Override
	public String getName() {
		return "布尔型";
	}

	@Override
	public String getCode() {
		return "boolean";
	}

}
