package org.cdl.demo.core.entity.model.field.type;

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
	public String getCode() {
		return "integer";
	}

}
