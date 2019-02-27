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
import org.cdl.demo.core.entity.model.field.FieldValue;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Content extends Base {

	private static final long serialVersionUID = 1L;

	@NonNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false, updatable = false)
	private Model model;

	@OneToMany(mappedBy = "content", cascade = CascadeType.ALL, orphanRemoval = true)
//	@MapKey(name = "code")
	private List<FieldValue<?>> fieldValues = new ArrayList<FieldValue<?>>();

	@Transient
	private Map<String, Object> fieldValueMap = null;

//	@SuppressWarnings("unchecked")
//	public Map<String, Object> getFieldValueMap() {
//		if (fieldValueMap == null) {
//			fieldValueMap = new HashMap<String, Object>();
//			for (FieldValue<?> fieldValue : fieldValues) {
//				String code = fieldValue.getCode();
//				if (fieldValueMap.containsKey(code)) {
//					Object value = fieldValueMap.get(code);
//					if (value instanceof List) {
//						((List<Object>) value).add(fieldValue.getValue());
//					} else {
//						List<Object> list = new ArrayList<Object>();
//						list.add(value);
//						list.add(fieldValue.getValue());
//						value = list;
//					}
//				} else {
//					fieldValueMap.put(code, fieldValue.getValue());
//				}
//			}
//		}
//		return fieldValueMap;
//	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getFieldValueMap() {
		if (fieldValueMap == null) {
			fieldValueMap = new HashMap<String, Object>();
			for (FieldValue<?> fieldValue : fieldValues) {
				String code = fieldValue.getCode();
				if (fieldValueMap.containsKey(code)) {
					Object value = fieldValueMap.get(code);
					if (value instanceof List) {
						((List<Object>) value).add(fieldValue);
					} else {
						List<Object> list = new ArrayList<Object>();
						list.add(value);
						list.add(fieldValue);
						value = list;
					}
				} else {
					fieldValueMap.put(code, fieldValue);
				}
			}
		}
		return fieldValueMap;
	}

}