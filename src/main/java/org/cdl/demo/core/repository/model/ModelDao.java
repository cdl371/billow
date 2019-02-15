package org.cdl.demo.core.repository.model;

import java.util.List;

import org.cdl.demo.core.entity.model.Model;
import org.cdl.demo.core.repository.BaseDao;
import org.cdl.demo.core.repository.content.aware.ItemAwareDao;
import org.springframework.data.domain.Sort;

public interface ModelDao extends BaseDao<Model>, ItemAwareDao<Model> {

	List<Model> findByCode(String code);

	List<Model> findByCode(String code, Sort sort);

	Model findByCodeAndChiefTrue(String code);

	boolean existsByCodeAndChiefTrue(String code);
	
	boolean existsByCodeAndChiefTrueAndIdNot(String code, Long id);
	
}
