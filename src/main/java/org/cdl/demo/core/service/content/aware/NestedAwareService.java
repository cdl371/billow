package org.cdl.demo.core.service.content.aware;

import org.cdl.demo.core.entity.Base;
import org.cdl.demo.core.repository.BaseDao;
import org.cdl.demo.core.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public interface NestedAwareService<T extends Base, DAO extends BaseDao<T>> extends BaseService<T, DAO> {

}
