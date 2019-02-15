package org.cdl.demo.core.repository.content.aware;

import java.util.List;

import org.cdl.demo.core.entity.content.aware.NestedAware;

public interface NestedAwareDao<T extends NestedAware> {

	List<T> findByParentId(Long id);

}
