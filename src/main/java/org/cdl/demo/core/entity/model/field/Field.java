package org.cdl.demo.core.entity.model.field;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.cdl.demo.core.entity.Base;
import org.cdl.demo.core.entity.model.FieldGroup;

@Entity
public class Field extends Base {

	private static final long serialVersionUID = 1L;

	private String name;

	private String code;

	@ManyToOne(fetch = FetchType.LAZY)
	private FieldGroup fieldGroup;

	public FieldGroup getFieldGroup() {
		return fieldGroup;
	}

	public void setFieldGroup(FieldGroup fieldGroup) {
		this.fieldGroup = fieldGroup;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
