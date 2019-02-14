package org.cdl.demo.core.repository.model;

import java.util.List;

import org.cdl.demo.core.entity.model.FieldGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FieldGroupDao extends JpaRepository<FieldGroup, Long> {

	public List<FieldGroup> findByModelId(Long id);

}
