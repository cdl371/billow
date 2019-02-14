package org.cdl.demo.core.service.content;

import org.cdl.demo.core.repository.content.NodeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Getter;

@Service("nodeService")
public class NodeServiceImpl implements NodeService {

	@Autowired
	@Getter
	private NodeDao dao;

}
