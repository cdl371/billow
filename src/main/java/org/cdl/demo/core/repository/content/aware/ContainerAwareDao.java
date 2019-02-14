package org.cdl.demo.core.repository.content.aware;

import java.util.List;

import org.cdl.demo.core.entity.content.aware.ContainerAware;
import org.springframework.data.domain.Sort;

public interface ContainerAwareDao<T extends ContainerAware> {

	List<T> findByContainerAssociationsItemId(Long id);

	List<T> findByContainerAssociationsItemId(Long id, Sort sort);

	T findByContainerAssociationsItemIdAndContainerAssociationsOwnTrue(Long id);

}
