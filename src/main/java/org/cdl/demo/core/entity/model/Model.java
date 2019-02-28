package org.cdl.demo.core.entity.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import org.cdl.demo.core.entity.Base;
import org.cdl.demo.core.entity.content.Content;
import org.cdl.demo.core.entity.content.Item;
import org.cdl.demo.core.entity.content.aware.ItemAware;
import org.cdl.demo.core.entity.model.field.Field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Model extends Base implements ItemAware {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	@NonNull
	private String code;

	@Getter
	@Setter
	@Column(columnDefinition = "bit default 0")
	private boolean primary = false;

	@Getter
	@Setter
	@OneToMany(mappedBy = "model")
	private List<Content> contents;

	@Getter
	@Setter
	@OneToMany(mappedBy = "model")
	@OrderBy("priority")
	private List<FieldGroup> fieldGroups = new ArrayList<FieldGroup>();

	@Getter
	@Setter
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinColumn(nullable = false, updatable = false)
	private Item item;

	@Transient
	private Map<String, Field> fieldMap = null;

	public Map<String, Field> parseFieldMap() {
		if (fieldMap == null) {
			fieldMap = new HashMap<String, Field>();
			for (FieldGroup fieldGroup : fieldGroups) {
				for (Field field : fieldGroup.getFields()) {
					fieldMap.put(field.getCode(), field);
				}
			}
		}
		return fieldMap;
	}

}
