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

	public static final String COLUMN_NAME = "text";

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = COLUMN_NAME)
	private String value;

	@Override
	public void setStringValue(String value) {
		setValue(value);
	}

}
