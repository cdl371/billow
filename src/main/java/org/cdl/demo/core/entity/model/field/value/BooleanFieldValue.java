package org.cdl.demo.core.entity.model.field.value;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.cdl.demo.core.entity.model.field.FieldValue;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("B")
public class BooleanFieldValue extends FieldValue<Boolean> {

	private static final long serialVersionUID = 1L;
	
	public static final String COLUMN_NAME = "boolean";

	@Column(name = COLUMN_NAME)
	private Boolean value;

	@Override
	public void setStringValue(String value) {
		setValue(Boolean.valueOf(value));
	}

}
