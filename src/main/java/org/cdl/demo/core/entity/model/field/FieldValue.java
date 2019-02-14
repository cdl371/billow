package org.cdl.demo.core.entity.model.field;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.cdl.demo.core.entity.Base;
import org.cdl.demo.core.entity.content.Content;

@Entity
public abstract class FieldValue extends Base<Long> {

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY)
	private Content content;

	@ManyToOne(fetch = FetchType.LAZY)
	private Field field;

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public abstract Object getValue();

	public abstract void setValue(String value);

}
