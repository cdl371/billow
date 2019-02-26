package org.cdl.demo.core.entity.content;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

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
	@MapKey(name = "code")
	private Map<String, FieldValue<?>> fieldValues = new HashMap<String, FieldValue<?>>();

//	@Transient
//	private Map<String, Object> fieldValueMap = null;
//
//	@SuppressWarnings("unchecked")
//	public Map<String, Object> getFieldValueMap() {
//		if (fieldValueMap == null) {
//			Map<String, Object> map = new HashMap<String, Object>();
//			for (FieldValue<?> fieldValue : fieldValues) {
//				String code = fieldValue.getCode();
//				if (map.containsKey(code)) {
//					Object value = map.get(code);
//					if (value instanceof List) {
//						((List<Object>) value).add(fieldValue.getValue());
//					} else {
//						List<Object> list = new ArrayList<Object>();
//						list.add(value);
//						list.add(fieldValue.getValue());
//						value = list;
//					}
//				} else {
//					map.put(code, fieldValue.getValue());
//				}
//			}
//			return map;
//		} else {
//			return fieldValueMap;
//		}
//	}
	
}