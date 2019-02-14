package org.cdl.demo.core.service.content;

import org.cdl.demo.core.repository.content.AssociationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Getter;

@Service("associationService")
public class AssociationServiceImpl implements AssociationService {

	@Autowired
	@Getter
	private AssociationDao dao;

}
