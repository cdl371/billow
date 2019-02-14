package org.cdl.demo.core.entity.content.aware;

import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public interface NestedAware<T> {

	@ManyToOne(fetch = FetchType.LAZY)
	public T getParent();

	public void setParent(T parent);
	
	@OneToMany(mappedBy = "parent")
	public List<T> getChildren();

	public void setChildren(List<T> children);
	
}
