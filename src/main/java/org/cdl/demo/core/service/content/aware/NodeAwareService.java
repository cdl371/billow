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

	static void checkParent(Node node, Node parent) {
		if (parent != null) {
			if (node.equals(parent)) {
				throw new IllegalArgumentException("ancestor id must not include the node id");
			} else {
				checkParent(node, parent.getParent());
			}
		}
	}

	default void attachParent(T nodeAware, T parentNodeAware) {
		checkParent(nodeAware.getNode(), parentNodeAware.getNode());
		nodeAware.getNode().setParent(parentNodeAware.getNode());
		getNodeService().save(nodeAware.getNode());
	}

	default void detachParent(T nodeAware) {
		nodeAware.getNode().setParent(null);
		getNodeService().save(nodeAware.getNode());
	}

	default T findByNodeId(Long nodeId) {
		return getNodeAwareDao().findByNodeId(nodeId);
	}

	default List<T> findByNodeParentId(Long parentNodeId) {
		return getNodeAwareDao().findByNodeParentId(parentNodeId);
	}

	default List<T> findByNodeLeafTrue() {
		return getNodeAwareDao().findByNodeLeafTrue();
	}

	default List<T> findByNodeParentIsNull() {
		return getNodeAwareDao().findByNodeParentIsNull();
	}

	default List<T> findByNodeLeafTrueAndNodeParentIsNull() {
		return getNodeAwareDao().findByNodeLeafTrueAndNodeParentIsNull();
	}

	default List<T> findByNodeLeafTrueAndNodeParentIsNullAndIdIsNot(Long id) {
		return getNodeAwareDao().findByNodeLeafTrueAndNodeParentIsNullAndIdIsNot(id);
	}

}
