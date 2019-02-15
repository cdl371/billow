package org.cdl.demo.core.repository.content;

import java.util.List;

import org.cdl.demo.core.entity.content.Item;
import org.cdl.demo.core.repository.BaseDao;

public interface ItemDao extends BaseDao<Item> {

	List<Item> findByAssociationsContainerId(Long containerId);

}
