package org.cdl.demo.core.service.model;

import java.util.List;

import org.cdl.demo.core.entity.model.Model;
import org.cdl.demo.core.repository.content.aware.ItemAwareDao;
import org.cdl.demo.core.repository.model.ModelDao;
import org.cdl.demo.core.service.content.AssociationService;
import org.cdl.demo.core.service.content.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import lombok.Getter;

@Service("modelService")
public class ModelServiceImpl implements ModelService {

	@Autowired
	@Getter
	private AssociationService associationService;

	@Autowired
	@Getter
	private ItemService itemService;

	@Autowired
	@Getter
	private ItemAwareDao<Model> itemAwareDao;

	@Autowired
	@Getter
	private ModelDao dao;

	@Override
	public List<Model> findByCode(String code) {
		return dao.findByCode(code);
	}

	@Override
	public Model findByCodeAndChiefTrue(String code) {
		return dao.findByCodeAndChiefTrue(code);
	}

	@Override
	public Model save(Model model) {
		checkChief(model);
		attachItem(model);
		return dao.save(model);
	}

	private void checkChief(Model model) {
		Assert.isTrue(
				!model.isChief() || !(model.isNew() ? dao.existsByCodeAndChiefTrue(model.getCode())
						: dao.existsByCodeAndChiefTrueAndIdNot(model.getCode(), model.getId())),
				"the chief model with same code must have only one");
	}

}
