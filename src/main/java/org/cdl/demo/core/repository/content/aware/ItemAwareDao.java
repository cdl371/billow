package org.cdl.demo.core.repository.content.aware;

import java.util.List;

import org.cdl.demo.core.entity.content.aware.ItemAware;
import org.springframework.data.domain.Sort;

public interface ItemAwareDao<T extends ItemAware> {

	List<T> findByItemAssociationsContainerId(Long containerId);

	List<T> findByItemAssociationsContainerId(Long containerId, Sort sort);

}
