package org.cdl.demo.core.entity.model.field;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

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

	private String option;

	@Column(columnDefinition = "int default 0")
	private Integer priority = 0;

	@ManyToOne(fetch = FetchType.LAZY)
	private FieldGroup fieldGroup;

}
