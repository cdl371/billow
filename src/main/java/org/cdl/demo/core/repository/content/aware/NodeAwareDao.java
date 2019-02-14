package org.cdl.demo.core.repository.content.aware;

import java.util.List;

import org.cdl.demo.core.entity.content.aware.NodeAware;

public interface NodeAwareDao<T extends NodeAware> {

	List<T> findByNodeParentId(Long id);

	T findByNodeId(Long id);

}
