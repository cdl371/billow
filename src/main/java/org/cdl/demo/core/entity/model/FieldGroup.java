package org.cdl.demo.core.entity.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.cdl.demo.core.entity.Base;
import org.cdl.demo.core.entity.model.field.Field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class FieldGroup extends Base {

	private static final long serialVersionUID = 1L;

	private String name;

	@Column(columnDefinition = "int default 0")
	private Integer priority = 0;

	@ManyToOne(fetch = FetchType.LAZY)
	private Model model;

	@OneToMany(mappedBy = "fieldGroup")
	@OrderBy("priority")
	private List<Field> fields = new ArrayList<Field>();

}
