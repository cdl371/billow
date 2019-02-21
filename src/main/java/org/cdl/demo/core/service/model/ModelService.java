package org.cdl.demo.core.service.model;

import java.util.List;

import org.cdl.demo.core.entity.model.Model;
import org.cdl.demo.core.repository.model.ModelDao;
import org.cdl.demo.core.service.BaseService;
import org.cdl.demo.core.service.content.aware.AssociationAwareService;
import org.cdl.demo.core.service.content.aware.ItemAwareService;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ModelService extends ItemAwareService<Model, ModelDao>, AssociationAwareService, BaseService<Model, ModelDao> {

	List<Model> findByCode(String code);

	Model findByCodeAndPrimaryTrue(String code);

	@Transactional
	Model save(Model model);

}
