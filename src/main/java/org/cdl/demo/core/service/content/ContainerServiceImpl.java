package org.cdl.demo.core.service.content;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.cdl.demo.core.repository.content.ContainerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Getter;

@Service("containerService")
public class ContainerServiceImpl implements ContainerService {

	@PersistenceContext
	@Getter
    private EntityManager entityManager;

	@Autowired
	@Getter
	private ContainerDao dao;

}
