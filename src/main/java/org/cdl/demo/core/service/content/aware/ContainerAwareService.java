package org.cdl.demo.core.service.content.aware;

import java.util.List;

import org.cdl.demo.core.entity.Base;
import org.cdl.demo.core.entity.content.Container;
import org.cdl.demo.core.entity.content.aware.ContainerAware;
import org.cdl.demo.core.repository.content.aware.ContainerAwareDao;
import org.cdl.demo.core.service.BaseService;
import org.cdl.demo.core.service.content.ContainerService;
import org.springframework.data.domain.Sort;

public interface ContainerAwareService<T extends Base<Long> & ContainerAware> extends BaseService<T, Long> {

	ContainerAwareDao<T> getContainerAwareDao();

	ContainerService getContainerService();

	default void attachContainer(T containerAware) {
		if (containerAware.isNew()) {
			containerAware.setContainer(getContainerService().save(new Container()));
		} else {
			containerAware.setContainer(findById(containerAware.getId()).getContainer());
		}
	}

	default List<T> findByItemAssociationsContainerId(Long id) {
		return getContainerAwareDao().findByContainerAssociationsItemId(id);
	}

	default List<T> findByItemAssociationsContainerId(Long id, Sort sort) {
		return getContainerAwareDao().findByContainerAssociationsItemId(id, sort);
	}

	default T findByContainerAssociationsItemIdAndContainerAssociationsOwnTrue(Long id) {
		return getContainerAwareDao().findByContainerAssociationsItemIdAndContainerAssociationsOwnTrue(id);
	}

}
