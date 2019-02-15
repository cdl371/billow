package org.cdl.demo.core.entity.content;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import org.cdl.demo.core.entity.Base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Container extends Base {

	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "containerId")
	private List<Association> associations;

}