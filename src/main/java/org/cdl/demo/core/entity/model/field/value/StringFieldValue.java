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
@DiscriminatorValue("S")
public class StringFieldValue extends FieldValue<String> {

	private static final long serialVersionUID = 1L;

	public static final String COLUMN_NAME = "string";

	@Column(name = COLUMN_NAME)
	private String value;

	@Override
	public void setStringValue(String value) {
		setValue(value);
	}

}
