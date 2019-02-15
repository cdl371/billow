package org.cdl.demo.core.entity.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.cdl.demo.core.entity.Base;
import org.cdl.demo.core.entity.model.field.Field;

@Entity
public class FieldGroup extends Base {

	private static final long serialVersionUID = 1L;

	private String name;

	@OneToMany(mappedBy = "fieldGroup")
	private List<Field> fields;

	@ManyToOne(fetch = FetchType.LAZY)
	private Model model;

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

}
