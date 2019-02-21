package org.cdl.demo.core.entity.model.field;

import java.lang.reflect.ParameterizedType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.cdl.demo.core.entity.Base;
import org.cdl.demo.core.entity.content.Content;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public abstract class FieldValue<T> extends Base {

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY)
	private Content content;

	private String code;

	public abstract T getValue();

	public abstract void setValue(T value);

	public abstract void setStringValue(String value);

	public void setStringValue(String[] value) {
		if (value != null && value.length > 0) {
			setStringValue(value[0]);
		}
	}

	@SuppressWarnings("unchecked")
	public Class<T> getValueType() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

}
