package org.cdl.demo.core.repository.content.aware;

import java.util.Collection;
import java.util.List;

import org.cdl.demo.core.entity.content.Item;
import org.cdl.demo.core.entity.content.aware.ItemAware;
import org.springframework.data.domain.Sort;

public interface ItemAwareDao<T extends ItemAware> {

	List<T> findByItemAssociationsContainerId(Long id);

	List<T> findByItemAssociationsContainerId(Long id, Sort sort);

	List<T> findByItemNotIn(Collection<Item> items);

}
