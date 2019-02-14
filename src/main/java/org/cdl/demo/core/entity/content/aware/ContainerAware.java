package org.cdl.demo.core.entity.content.aware;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.cdl.demo.core.entity.content.Container;

public interface ContainerAware {

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinColumn(nullable = false, updatable = false)
	public Container getContainer();

	public void setContainer(Container container);

}
