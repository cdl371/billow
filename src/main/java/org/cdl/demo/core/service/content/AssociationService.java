package org.cdl.demo.core.service.content;

import java.util.List;

import org.cdl.demo.core.entity.content.Association;
import org.cdl.demo.core.entity.content.AssociationId;
import org.cdl.demo.core.repository.content.AssociationDao;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface AssociationService {

	AssociationDao getDao();

	default List<Association> findAll() {
		return getDao().findAll();
	}

	default List<Association> findAll(Sort sort) {
		return getDao().findAll(sort);
	}

	default Association findById(AssociationId id) {
		return getDao().findById(id).get();
	}

	@Transactional
	default Association save(Association entity) {
		return getDao().save(entity);
	}

	@Transactional
	default void delete(AssociationId id) {
		getDao().deleteById(id);
	}

}
