package org.cdl.demo.core.service.content.aware;

import java.util.List;

import org.cdl.demo.core.entity.Base;
import org.cdl.demo.core.entity.content.Node;
import org.cdl.demo.core.entity.content.aware.NodeAware;
import org.cdl.demo.core.repository.BaseDao;
import org.cdl.demo.core.repository.content.aware.NodeAwareDao;
import org.cdl.demo.core.service.BaseService;
import org.cdl.demo.core.service.content.NodeService;

public interface NodeAwareService<T extends Base & NodeAware, DAO extends BaseDao<T>> extends BaseService<T, DAO> {

	NodeAwareDao<T> getNodeAwareDao();

	NodeService getNodeService();

	default void attachNode(T nodeAware) {
		if (nodeAware.isNew()) {
			nodeAware.setNode(getNodeService().save(new Node()));
		} else {
			nodeAware.setNode(findById(nodeAware.getId()).getNode());
		}
	}

	default void attachParent(T nodeAware, Long parentNodeId) {
		attachNode(nodeAware);
		getNodeService().attachParent(nodeAware.getNode(), parentNodeId);
	}

	default T findByNodeId(Long nodeId) {
		return getNodeAwareDao().findByNodeId(nodeId);
	}

	default List<T> findByNodeParentId(Long parentNodeId) {
		return getNodeAwareDao().findByNodeParentId(parentNodeId);
	}

	default List<T> findByNodeLeafTrueAndNodeParentIsNull() {
		return getNodeAwareDao().findByNodeLeafTrueAndNodeParentIsNull();
	}

}
