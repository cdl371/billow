package org.cdl.demo.core.entity.model.field.value;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.cdl.demo.core.entity.model.field.FieldValue;

@Entity
@DiscriminatorValue("S")
public class StringFieldValue extends FieldValue {

	private static final long serialVersionUID = 1L;

	private String stringValue;

	@Override
	public String getValue() {
		return stringValue;
	}

	@Override
	public void setValue(String value) {
		this.stringValue = value;
	}

}
