package org.cdl.demo.core.entity.content.aware;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import org.cdl.demo.core.entity.content.Content;

public interface ContentAware {

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Content getContent();

	public void setContent(Content content);

}
