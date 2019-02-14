package org.cdl.demo.core.entity.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.cdl.demo.core.entity.Base;
import org.cdl.demo.core.entity.content.Content;
import org.cdl.demo.core.entity.content.Item;
import org.cdl.demo.core.entity.content.aware.ItemAware;

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
public class Model extends Base<Long> implements ItemAware {

	private static final long serialVersionUID = 1L;

	private String name;

	@NonNull
	private String code;

	@Column(columnDefinition = "bit default 0")
	private boolean chief = false;

	@OneToMany(mappedBy = "model")
	private List<Content> contents;

	@OneToMany(mappedBy = "model")
	private List<FieldGroup> fieldGroups = new ArrayList<FieldGroup>();

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinColumn(nullable = false, updatable = false)
	private Item item;

}
