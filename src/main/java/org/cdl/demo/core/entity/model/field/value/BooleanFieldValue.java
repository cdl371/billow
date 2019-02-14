package org.cdl.demo.core.entity.model.field.value;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.cdl.demo.core.entity.model.field.FieldValue;

@Entity
@DiscriminatorValue("B")
public class BooleanFieldValue extends FieldValue {

	private static final long serialVersionUID = 1L;

	private Boolean booelanValue;

	@Override
	public Boolean getValue() {
		return booelanValue;
	}

	@Override
	public void setValue(String value) {
		this.booelanValue = Boolean.valueOf(value);
	}

}
