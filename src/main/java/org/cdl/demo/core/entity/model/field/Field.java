package org.cdl.demo.core.entity.model.field;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;

import org.cdl.demo.core.entity.Base;
import org.cdl.demo.core.entity.model.FieldGroup;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Field extends Base {

	private static final long serialVersionUID = 1L;

	private String name;

	private String code;

	private String type;

	@Column(columnDefinition = "bit default 0")
	private boolean required = false;

	@ElementCollection
	@CollectionTable(name = "field_option", joinColumns = @JoinColumn(name = "field_id"))
	@MapKeyColumn(name = "code", length = 32)
	@Column(name = "option")
	private Map<String, String> options = new HashMap<String, String>();

	@Column(columnDefinition = "int default 0")
	private Integer priority = 0;

	@ManyToOne(fetch = FetchType.LAZY)
	private FieldGroup fieldGroup;

}
