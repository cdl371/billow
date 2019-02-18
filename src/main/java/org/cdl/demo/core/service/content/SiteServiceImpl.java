package org.cdl.demo.core.service.content;

import org.cdl.demo.core.entity.content.Content;
import org.cdl.demo.core.entity.content.Site;
import org.cdl.demo.core.repository.content.SiteDao;
import org.cdl.demo.core.repository.content.aware.ContainerAwareDao;
import org.cdl.demo.core.repository.content.aware.NodeAwareDao;
import org.cdl.demo.core.service.model.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Getter;

@Service("siteService")
public class SiteServiceImpl implements SiteService {

	@Autowired
	@Getter
	private SiteDao dao;

	@Autowired
	private ModelService modelService;

	@Autowired
	@Getter
	private ContainerService containerService;

	@Autowired
	@Getter
	private AssociationService associationService;

	@Autowired
	@Getter
	private ContainerAwareDao<Site> containerAwareDao;

	@Autowired
	@Getter
	private NodeAwareDao<Site> nodeAwareDao;

	@Autowired
	@Getter
	private NodeService nodeService;

	@Override
	public void save(Site site, Long model_id) {
		if (site.isChief()) {
			Site chiefSite = dao.findByChiefTrue();
			if (chiefSite != null && chiefSite.getId() != site.getId()) {
				throw new IllegalArgumentException("the chief site must have only one");
			}
		}
		attachContainer(site);
		attachNode(site);
		if (site.getId() == null) {
			site.setContent(new Content(modelService.findById(model_id)));
		} else {
			Site old = findById(site.getId());
			site.setContent(old.getContent());
		}
		dao.save(site);
	}

	@Override
	public Site findByChiefTrue() {
		return dao.findByChiefTrue();
	}

	@Override
	public Site findOneByDomain(String domain) {
		return dao.findOneByDomain(domain);
	}

}
