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

	@Column(name = "string")
	private String value;

	@Override
	public void setStringArrayValue(String[] value) {
		if (value != null && value.length > 0) {
			setValue(value[0]);
		}
	}

}
