package org.cdl.demo.core.entity.model.field.value;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.cdl.demo.core.entity.model.field.FieldValue;

@Entity
@DiscriminatorValue("I")
public class IntegerFieldValue extends FieldValue {

	private static final long serialVersionUID = 1L;

	private Integer integerValue;

	@Override
	public Integer getValue() {
		return integerValue;
	}

	@Override
	public void setValue(String value) {
		this.integerValue = Integer.valueOf(value);
	}

}
