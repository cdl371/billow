package org.cdl.demo.core.service.content;

import org.cdl.demo.core.entity.content.Site;
import org.cdl.demo.core.repository.content.SiteDao;
import org.cdl.demo.core.service.BaseService;
import org.cdl.demo.core.service.content.aware.AssociationAwareService;
import org.cdl.demo.core.service.content.aware.ContainerAwareService;
import org.cdl.demo.core.service.content.aware.NodeAwareService;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface SiteService extends ContainerAwareService<Site, SiteDao>, AssociationAwareService, NodeAwareService<Site, SiteDao>, BaseService<Site, SiteDao> {

	@Transactional
	void save(Site site, Long model_id);

	Site findByChiefTrue();

	Site findOneByDomain(String domain);

}
