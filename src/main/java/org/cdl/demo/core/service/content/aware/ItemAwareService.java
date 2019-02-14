package org.cdl.demo.core.service.content.aware;

import java.util.List;

import org.cdl.demo.core.entity.Base;
import org.cdl.demo.core.entity.content.Item;
import org.cdl.demo.core.entity.content.aware.ItemAware;
import org.cdl.demo.core.repository.content.aware.ItemAwareDao;
import org.cdl.demo.core.service.BaseService;
import org.cdl.demo.core.service.content.ItemService;
import org.springframework.data.domain.Sort;

public interface ItemAwareService<T extends Base<Long> & ItemAware> extends BaseService<T, Long> {

	ItemAwareDao<T> getItemAwareDao();

	ItemService getItemService();

	default void attachItem(T itemAware) {
		if (itemAware.isNew()) {
			itemAware.setItem(getItemService().save(new Item()));
		} else {
			itemAware.setItem(findById(itemAware.getId()).getItem());
		}
	}

	default List<T> findByItemAssociationsContainerId(Long id) {
		return getItemAwareDao().findByItemAssociationsContainerId(id);
	}

	default List<T> findByItemAssociationsContainerId(Long id, Sort sort) {
		return getItemAwareDao().findByItemAssociationsContainerId(id, sort);
	}

//	default List<T> findByItemNotInContainer(Long containerId) {
//		return getItemAwareDao().findByItemNotIn(getItemService().findByAssociationsContainerId(containerId));
//	}

}
