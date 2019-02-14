package org.cdl.demo.core.service.content;

import java.util.List;

import org.cdl.demo.core.entity.content.Item;
import org.cdl.demo.core.service.BaseService;

public interface ItemService extends BaseService<Item, Long> {

	List<Item> findByAssociationsContainerId(Long containerId);

}
