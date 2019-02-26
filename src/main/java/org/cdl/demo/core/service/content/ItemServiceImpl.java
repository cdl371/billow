package org.cdl.demo.core.service.content;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.cdl.demo.core.repository.content.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Getter;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

	@PersistenceContext
	@Getter
    private EntityManager entityManager;

	@Autowired
	@Getter
	private ItemDao dao;

}
