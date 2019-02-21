package org.cdl.demo.core.service.model;

import org.cdl.demo.core.repository.model.FieldGroupDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Getter;

@Service("fieldGroupService")
public class FieldGroupServiceImpl implements FieldGroupService {

	@Autowired
	@Getter
	private FieldGroupDao dao;

}
