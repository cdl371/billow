package org.cdl.demo.core.service.content;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.cdl.demo.core.entity.model.field.FieldType;
import org.cdl.demo.core.repository.content.ContentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lombok.Getter;

@Service("contentService")
public class ContentServiceImpl implements ContentService {

	@PersistenceContext
	@Getter
    private EntityManager entityManager;

	@Autowired
	@Getter
	private ContentDao dao;

	@Autowired
	@Qualifier("fieldTypeMap")
	private Map<String, FieldType<?>> fieldTypeMap;

}
