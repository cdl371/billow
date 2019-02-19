package org.cdl.demo.core.entity.content;

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
import org.cdl.demo.core.entity.model.field.Field;
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

	@OneToMany(mappedBy = "content", cascade = CascadeType.ALL)
	@MapKey(name = "field")
	private Map<Field, FieldValue> fieldValues;

}