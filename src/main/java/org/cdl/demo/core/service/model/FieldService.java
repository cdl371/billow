package org.cdl.demo.core.service.model;

import java.util.List;

import org.cdl.demo.core.entity.model.field.Field;
import org.cdl.demo.core.repository.model.FieldDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FieldService {

	@Autowired
	private FieldDao fieldDao;

	public List<Field> findAll() {
		return fieldDao.findAll();
	}

	public Field findById(Long id) {
		return fieldDao.findById(id).get();
	}

	public List<Field> findByFieldGroupId(Long id) {
		return fieldDao.findByFieldGroupId(id);
	}

	public void save(Field field) {
		fieldDao.save(field);
	}

	public void delete(Long id) {
		fieldDao.deleteById(id);
	}

}
