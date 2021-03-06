package org.cdl.demo.core.service.content;

import org.cdl.demo.core.entity.content.Node;
import org.cdl.demo.core.repository.content.NodeDao;
import org.cdl.demo.core.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public interface NodeService extends BaseService<Node, NodeDao> {

}
