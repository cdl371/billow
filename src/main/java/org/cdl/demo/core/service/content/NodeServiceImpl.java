package org.cdl.demo.core.service.content;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.cdl.demo.core.repository.content.NodeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Getter;

@Service("nodeService")
public class NodeServiceImpl implements NodeService {

	@PersistenceContext
	@Getter
    private EntityManager entityManager;

	@Autowired
	@Getter
	private NodeDao dao;

}
