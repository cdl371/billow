package org.cdl.demo.core.entity.model.field.value;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;

import org.cdl.demo.core.entity.model.field.FieldValue;

@Entity
@DiscriminatorValue("T")
public class TextFieldValue extends FieldValue {

	private static final long serialVersionUID = 1L;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	private String textValue;

	@Override
	public String getValue() {
		return textValue;
	}

	@Override
	public void setValue(String value) {
		this.textValue = value;
	}

}
