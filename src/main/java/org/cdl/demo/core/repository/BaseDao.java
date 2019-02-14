package org.cdl.demo.core.repository;

import org.cdl.demo.core.entity.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseDao<T extends Base<ID>, ID> extends JpaRepository<T, ID> {

}
