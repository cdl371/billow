package org.cdl.demo.core.entity.model.field.value;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;

import org.cdl.demo.core.entity.model.field.FieldValue;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("T")
public class TextFieldValue extends FieldValue<String> {

	private static final long serialVersionUID = 1L;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "text")
	private String value;

	@Override
	public void setStringArrayValue(String[] value) {
		if (value != null && value.length > 0) {
			setValue(value[0]);
		}
	}

}
