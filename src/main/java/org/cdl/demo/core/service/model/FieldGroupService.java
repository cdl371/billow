package org.cdl.demo.core.service.model;

import org.cdl.demo.core.entity.model.FieldGroup;
import org.cdl.demo.core.repository.model.FieldGroupDao;
import org.cdl.demo.core.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface FieldGroupService extends BaseService<FieldGroup, FieldGroupDao> {

}
