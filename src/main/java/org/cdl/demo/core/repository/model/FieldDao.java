package org.cdl.demo.core.repository.model;

import java.util.List;

import org.cdl.demo.core.entity.model.field.Field;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FieldDao extends JpaRepository<Field, Long> {

	public List<Field> findByFieldGroupId(Long id);

}
