package org.cdl.demo.core.service.content;

import java.util.List;

import org.cdl.demo.core.entity.content.Item;
import org.cdl.demo.core.repository.content.ItemDao;
import org.cdl.demo.core.service.BaseService;

public interface ItemService extends BaseService<Item, ItemDao> {

	List<Item> findByAssociationsContainerId(Long containerId);

}
