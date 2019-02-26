package org.cdl.demo.core.entity.model.field.value;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.cdl.demo.core.entity.Base;
import org.cdl.demo.core.entity.model.field.FieldValue;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("SL")
public class StringListFieldValue extends FieldValue<List<String>> {

	private static final long serialVersionUID = 1L;

	@ElementCollection
	@CollectionTable(name = "field_value_string", joinColumns = @JoinColumn(name = "field_value_id"))
	private List<String> value;

	@Override
	public void setStringArrayValue(String[] value) {
		if (value != null && value.length > 0) {
			setValue(Arrays.asList(value));
		}
	}

	@Getter
	@Setter
	@Entity
	@Table(name = "field_value_string")
	private class FieldValueString extends Base {

		private static final long serialVersionUID = 1L;

	}

}
