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
@DiscriminatorValue("I")
public class IntegerFieldValue extends FieldValue<Integer> {

	private static final long serialVersionUID = 1L;

	@Column(name = "integer")
	private Integer value;

	@Override
	public void setStringValue(String value) {
		setValue(Integer.valueOf(value));
	}

}
