package org.cdl.demo.core.repository.content;

import java.util.List;

import org.cdl.demo.core.entity.content.Site;
import org.cdl.demo.core.repository.BaseDao;
import org.cdl.demo.core.repository.content.aware.ContainerAwareDao;
import org.cdl.demo.core.repository.content.aware.ContentAwareDao;
import org.cdl.demo.core.repository.content.aware.NodeAwareDao;
import org.springframework.data.jpa.repository.Query;

public interface SiteDao extends BaseDao<Site>, ContainerAwareDao<Site>, NodeAwareDao<Site>, ContentAwareDao<Site> {

	boolean existsByPrimaryTrue();

	boolean existsByPrimaryTrueAndIdNot(Long id);

	Site findByPrimaryTrue();

	Site findOneByHost(String host);

	@Query(value = "select s.* from site s left outer join content c on s.content_id=c.id left outer join field_value fv on c.id=fv.content_id where fv.code='weight' and fv.integer='12'", nativeQuery = true)
	List<Site> findTest();

}
