package org.cdl.demo.core.service.model;

import java.util.List;

import org.cdl.demo.core.entity.model.FieldGroup;
import org.cdl.demo.core.repository.model.FieldGroupDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FieldGroupService {

	@Autowired
	private FieldGroupDao fieldGroupDao;

	public List<FieldGroup> findAll() {
		return fieldGroupDao.findAll();
	}

	public FieldGroup findById(Long id) {
		return fieldGroupDao.findById(id).get();
	}

	public List<FieldGroup> findByModelId(Long id) {
		return fieldGroupDao.findByModelId(id);
	}

	public void save(FieldGroup fieldGroup) {
		fieldGroupDao.save(fieldGroup);
	}

	public void delete(Long id) {
		fieldGroupDao.deleteById(id);
	}

}
