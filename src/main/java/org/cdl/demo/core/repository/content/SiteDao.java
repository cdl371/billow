package org.cdl.demo.core.repository.content;

import org.cdl.demo.core.entity.content.Site;
import org.cdl.demo.core.repository.BaseDao;
import org.cdl.demo.core.repository.content.aware.ContainerAwareDao;
import org.cdl.demo.core.repository.content.aware.NodeAwareDao;

public interface SiteDao extends BaseDao<Site>, ContainerAwareDao<Site>, NodeAwareDao<Site> {

	Site findByChiefTrue();

	Site findOneByDomain(String domain);

}
