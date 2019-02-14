package org.cdl.demo.core.service;

import java.util.List;

import org.cdl.demo.core.entity.Base;
import org.cdl.demo.core.repository.BaseDao;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

public interface BaseService<T extends Base<ID>, ID> {

	BaseDao<T, ID> getDao();

	default List<T> findAll() {
		return getDao().findAll();
	}

	default List<T> findAll(Sort sort) {
		return getDao().findAll(sort);
	}

	default T findById(ID id) {
		return getDao().findById(id).get();
	}

	@Transactional
	default T save(T entity) {
		return getDao().save(entity);
	}

	@Transactional
	default void delete(ID id) {
		getDao().deleteById(id);
	}

}
