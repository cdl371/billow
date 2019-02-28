package org.cdl.demo.core.entity.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.cdl.demo.core.entity.Base;
import org.cdl.demo.core.entity.model.Model;
import org.cdl.demo.core.entity.model.field.Field;
import org.cdl.demo.core.entity.model.field.FieldType;
import org.cdl.demo.core.entity.model.field.FieldValue;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Content extends Base {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	@NonNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false, updatable = false)
	private Model model;

	@Getter
	@Setter
	@OneToMany(mappedBy = "content", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<FieldValue<?>> fieldValues = new ArrayList<FieldValue<?>>();

	@Transient
	private Map<String, FieldValue<?>> fieldValueMap = null;

	public Map<String, FieldValue<?>> parseFieldValueMap(Map<String, FieldType<?>> fieldTypes) {
		if (fieldValueMap == null) {
			fieldValueMap = new HashMap<String, FieldValue<?>>();
			Map<String, Field> fieldMap = model.parseFieldMap();
			for (FieldValue<?> fieldValue : fieldValues) {
				String code = fieldValue.getCode();
				Field field = fieldMap.get(code);
				FieldType<?> fieldType = fieldTypes.get(field.getType());
				if (fieldType.isSingle()) {
					fieldValueMap.put(code, fieldValue);
				} else {
					FieldValueList list;
					if (fieldValueMap.containsKey(code)) {
						list = (FieldValueList) fieldValueMap.get(code);
					} else {
						list = new FieldValueList();
						list.setCode(code);
						list.setContent(this);
					}
					list.add(fieldValue);
					fieldValueMap.put(code, list);
				}
			}
		}
		return fieldValueMap;
	}

	private static class FieldValueList extends FieldValue<List<Object>> {

		private static final long serialVersionUID = 1L;

		private List<Object> list = new ArrayList<Object>();

		private void add(FieldValue<?> fieldValue) {
			list.add(fieldValue.getValue());
		}

		@Override
		public List<Object> getValue() {
			return list;
		}

		@Override
		public void setValue(List<Object> value) {
		}

		@Override
		public void setStringValue(String value) {
		}

	}

}