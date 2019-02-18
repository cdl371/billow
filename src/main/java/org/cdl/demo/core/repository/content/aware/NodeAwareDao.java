package org.cdl.demo.core.repository.content.aware;

import java.util.List;

import org.cdl.demo.core.entity.content.aware.NodeAware;

public interface NodeAwareDao<T extends NodeAware> {

	T findByNodeId(Long nodeId);

	List<T> findByNodeParentId(Long parentNodeId);

	List<T> findByNodeLeafTrue();

	List<T> findByNodeParentIsNull();

	List<T> findByNodeLeafTrueAndNodeParentIsNull();

	List<T> findByNodeLeafTrueAndNodeParentIsNullAndIdIsNot(Long id);

}
